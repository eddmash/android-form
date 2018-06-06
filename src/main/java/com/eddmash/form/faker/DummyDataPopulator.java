package com.eddmash.form.faker;
/*
 * This file is part of the androidcomponents package.
 *
 * (c) Eddilbert Macharia (http://eddmash.com)<edd.cowan@gmail.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;

import com.eddmash.form.FormException;
import com.eddmash.form.FormInterface;
import com.eddmash.form.faker.provider.ProviderInterface;
import com.eddmash.form.fields.CollectionFieldInterface;
import com.eddmash.form.fields.FieldInterface;
import com.eddmash.form.fields.MultiFieldInterface;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * This is a minimalistic go at data faker.
 * <p>
 * This intention is to populate the FormInterface and FieldInterfaces.
 */
public class DummyDataPopulator implements PopulatorInterface {
    private Guess guesser;
    private Map<String, ProviderInterface> fieldPopulators;
    private boolean populationComplete = false;
    private Map<Class, ProviderInterface> classPopulators;


    public DummyDataPopulator() {
        fieldPopulators = new HashMap<>();
        classPopulators = new HashMap<>();
        guesser = new Guess(this);
    }

    public void setFieldProvider(String name, ProviderInterface provider) {
        fieldPopulators.put(name, provider);
    }

    public void setFieldProvider(Class clazz, ProviderInterface provider) {
        classPopulators.put(clazz, provider);
    }

    public void populate(FormInterface form) throws FormException {
        if (!populationComplete) {

            Log.e(
                    DummyDataPopulator.class.getName(),
                    form.getClass().getName() +
                            " ::: Loading  data ::: " + form.getFields()
            );

            FieldInterface field;

            for (String fieldName : form.getFields().keySet()) {
                field = form.getField(fieldName);
                populate(field);
            }
            populationComplete = true;
        }
    }

    public void populate(FieldInterface field) throws FormException {
        if (field.isEditable()) {

            if (field instanceof CollectionFieldInterface) {

                Map<String, FieldInterface> collectionFields =
                        ((CollectionFieldInterface) field).getFields();
                for (FieldInterface cField : collectionFields.values()) {
                    if (cField.isEditable()) {
                        populate(cField);
                    }
                }
            } else if (field instanceof MultiFieldInterface) {
                int i = 0;
                MultiFieldInterface multiField = ((MultiFieldInterface) field);

                for (FieldInterface innerField : multiField.getFields()) {
                    innerField = multiField.getFields().get(i);
                    populate(innerField);
                    i++;
                }

            } else {
                Log.e(getClass().getSimpleName(), "FIELD :: " + field.getName() +
                        " VIEW CLASS :: " + field.getClass().getName());
                try {
                    field.setValue(generateData(field.getName(), (View) field.getView()));
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.e(getClass().getSimpleName(), e.getMessage());
                }
            }
        }
    }

    private Object generateData(String fieldName, View field) throws
            FormException {
        try {
            if (fieldPopulators.containsKey(fieldName)) {
                return fieldPopulators.get(fieldName).getData(field);
            } else if (classPopulators.containsKey(field.getClass())) {
                return classPopulators.get(field.getClass()).getData(field);
            }
        } catch (Exception e) {
            // just ignore this and continue proccessing
        }

        if (field instanceof EditText) {

            try {
                return guesser.guess(fieldName, field);
            } catch (FakerException e) {
                e.printStackTrace();
                throw new FormException(e.getMessage());
            }
        }

        if (field instanceof Spinner) {
            int count = 0;
            try {
                count = ((Spinner) field).getAdapter().getCount();
            } catch (Exception e) {

            }
            if (count == 1 || count == 0) {
                return String.valueOf(0);
            }
            Random rand = new Random();
            int value = rand.nextInt(count);
            while (value == 0) {
                value = rand.nextInt(count);
                Log.e("SPINNER VAL", count + " :: " + String.valueOf(value));
            }
            return String.valueOf(value);
        }

        if (field instanceof CompoundButton) {
            return "true";
        }

        throw new FormException(
                "Unable to generate dummy data form " + fieldName);
    }

}

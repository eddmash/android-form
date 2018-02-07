package com.eddmash.form.faker;
/*
* This file is part of the Tools package.
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
import com.eddmash.form.fields.CollectionField;
import com.eddmash.form.fields.MultiField;
import com.eddmash.form.fields.MultiFieldInterface;
import com.eddmash.form.fields.SimpleField;
import com.eddmash.form.fields.ViewField;
import com.eddmash.form.fields.FieldInterface;
import com.eddmash.views.CollectionView;

import java.util.HashMap;
import java.util.List;
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


    public DummyDataPopulator() {
        fieldPopulators = new HashMap<>();
        guesser = new Guess(this);
    }

    public void setFieldProvider(String name, ProviderInterface provider) {
        provider.setPopulator(this);
        fieldPopulators.put(name, provider);
    }

    public void populate(FormInterface form) throws FormException {
        if (!populationComplete) {

            Log.e(DummyDataPopulator.class.getName(), form.getClass().getName() +
                    " ::: Loading  data ::: " + form.getFields());

            FieldInterface field;

            for (String fieldName : form.getFields().keySet()) {
                field = form.getField(fieldName);
                populate(field);
            }
            populationComplete = true;
        }
    }

    public void populate(FieldInterface field) throws FormException {
        String val;
        Log.e(DummyDataPopulator.class.getSimpleName(),
                "POPULATING :: " + field.getForm().getClass().getSimpleName()
                        + "::" + field.getClass().getSimpleName()
                        + " " + field.getName() + " Editable " + field.isEditable());
        if (field.isEditable() && !(field instanceof SimpleField)) {

            if (field instanceof ViewField) {
                val = generateData(field.getName(), (View) field.getView());
                field.setValue(val);
            } else if (field instanceof CollectionField) {

                Map<String, FieldInterface> collectionFields = ((CollectionField) field)
                        .getFields();
                for (FieldInterface cField : collectionFields.values()) {
                    Log.e(DummyDataPopulator.class.getSimpleName(),
                            cField.getClass().getSimpleName() + " " +
                                    "::: cField ::: " + cField.getName());
                    if (cField.isEditable() && !(cField instanceof SimpleField)) {
                        cField.setValue(generateData(cField.getName(), (View) cField.getView()));
                    }
                }
            } else if (field instanceof MultiFieldInterface) {

                Log.e(getClass().getSimpleName(), field.getClass().getSimpleName() + " :: " +
                        field.getName());
                int i = 0;
                MultiField multiField = ((MultiField) field);
                int count = multiField.getChildCount();

                Random rand = new Random();
                int limit = rand.nextInt(count);
                Log.e(getClass().getSimpleName(),
                        field.getClass().getSimpleName() + " found " + count + " LIMIT " + limit);
                FieldInterface innerField;
                while (count > 0 && i < limit) {
                    innerField = multiField.getFields().get(i);
                    innerField.setValue(generateData(field.getName(), (View) innerField.getView()));
                    i++;
                }

            }
        }
    }

    private String generateData(String fieldName, View field) throws
            FormException {

        if (fieldPopulators.containsKey(fieldName)) {
            try {
                return String.valueOf(fieldPopulators.get(fieldName));
            } catch (Exception e) {
                e.printStackTrace();
                Log.e(getClass().getName(), e.getMessage() + " :: Falling back to guessing");
            }
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
            int count = ((Spinner) field).getAdapter().getCount();
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

        throw new FormException("Unable to generate dummy data form " + fieldName);
    }

}

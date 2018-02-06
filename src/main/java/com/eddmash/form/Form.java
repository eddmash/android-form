package com.eddmash.form;
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

import com.eddmash.form.fields.CollectionField;
import com.eddmash.form.fields.FieldInterface;
import com.eddmash.form.fields.ViewField;
import com.eddmash.validation.Validator;
import com.eddmash.validation.ValidatorInterface;
import com.eddmash.validation.checks.CheckInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Form implements FormInterface {
    private Map data;
    private Map<String, Object> extraFields;
    private ValidatorInterface validator;
    private Map<String, ArrayList<String>> orderMap;
    private Map<String, FieldInterface> fields;

    public Form() {
        init(new Validator(getIdentifier()));
    }

    public Form(ValidatorInterface validator) {
        init(validator);
    }

    private void init(ValidatorInterface validator) {
        data = new HashMap();
        orderMap = new HashMap<>();
        fields = new HashMap<>();
        this.validator = validator;
        extraFields = new HashMap<>();
        try {
            setData(data);
        } catch (FormException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getIdentifier() {
        return getClass().getName();
    }

    @Override
    public void addCheck(CheckInterface check) {
        if (check instanceof FormAwareInterface) {
            ((FormAwareInterface) check).setForm(this);
        }
        validator.addCheck(check);
    }

    @Override
    public void disableCheck(CheckInterface check) {
        validator.disableCheck(check);
    }

    @Override
    public Map<String, FieldInterface> getFields() {
        return fields;
    }

    @Override
    public FieldInterface getField(String fieldName) throws FormException {
        if (!fields.containsKey(fieldName)) {
            throw new FormException("Form does not contain the field " + fieldName);
        }
        return fields.get(fieldName);
    }

    @Override
    public void addField(String colName, View view) {

        fields.put(colName, new ViewField(colName, view).setForm(this));
    }


    @Override
    public void removeField(String colName) {
        if (fields.containsKey(colName)) {
            fields.remove(colName);
        }
    }

    @Override
    public void addField(FieldInterface field) {
        fields.put(field.getName(), field.setForm(this));
    }

    @Override
    public void removeField(FieldInterface field) {
        removeField(field.getName());
    }

    @Override
    public boolean isValid() {
        validate();
        return validator.validate();
    }

    @Override
    public void validate() {

    }

    @Override
    public void setData(Map data) throws FormException {
        if (data != null && !data.isEmpty()) {

            for (FieldInterface field : fields.values()) {
                if (data.containsKey(field.getName())) {
                    field.setValue(data.get(field.getName()));
                }

                if (field instanceof CollectionField) {
                    field.setValue(data);
                }
            }
        }
    }

    public Map<String, Object> getValues() throws FormException {

        Map<String, Object> values = new HashMap<>();

        for (String key : extraFields.keySet()) {
            values.put(key, extraFields.get(key));
        }

        for (String fieldName : fields.keySet()) {
            values.put(fieldName, fields.get(fieldName).getValue());
        }
        Log.e(getClass().getSimpleName(), " :: DATA " + values);
        return values;
    }

    @Override
    public Object getValue(String fieldName) throws FormException {
        Map<String, Object> vals = getValues();
        if (!vals.containsKey(fieldName)) {
            throw new FormException("ViewField " + fieldName + " has not been set");
        }
        return vals.get(fieldName);
    }

    @Override
    public void setValue(String fieldName, Object value) {
        extraFields.put(fieldName, value);
    }


    @Override
    public Map<String, List> getErrors() {
        return validator.getErrors();
    }
}

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

import com.eddmash.form.fields.ViewField;
import com.eddmash.form.fields.FieldInterface;
import com.eddmash.validation.ValidatorInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class Form implements FormInterface {
    private Map data;
    private Map<String, Object> extraFields;
    private ValidatorInterface validator;
    private Map<String, ArrayList<String>> orderMap;
    private Map<String, FieldInterface> fields;

    public Form(ValidatorInterface validator) {
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
    public ValidatorInterface getValidator() {
        return validator;
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
        return validator.validate();
    }

    @Override
    public void setData(Map data) throws FormException {
        if (data != null && !data.isEmpty()) {
            for (String fieldName : fields.keySet()) {
                if (!data.containsKey(fieldName)) {
                    continue;
                }
                fields.get(fieldName).setValue(data.get(fieldName));
            }
        }
    }

    private String getTag() {
        return getClass().getName();
    }

    public Map<String, Object> getValues() throws FormException {

        Map<String, Object> values = new HashMap<>();

        for (String key : extraFields.keySet()) {
            values.put(key, extraFields.get(key));
        }

        for (String fieldName : fields.keySet()) {
            values.put(fieldName, fields.get(fieldName).getValue());
        }
        Log.e(getTag(), " FORM  :: " + this.getTag() + " :: DATA " + values);
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

}

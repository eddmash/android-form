package com.eddmash.form.fields;
/*
 * This file is part of the androidcomponents package.
 *
 * (c) Eddilbert Macharia (http://eddmash.com)<edd.cowan@gmail.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

import android.view.View;

import com.eddmash.form.FormException;
import com.eddmash.form.FormInterface;
import com.eddmash.form.NonViewValueInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Field that manipulates multiple individual views together.
 * <p>
 * Its important to note that the specific fields don't loose there
 * individuality and the values return will be values for each single view.
 * <p>
 * Setting will be attempted on each single view if its value is found in the
 * map of values passed in.
 */
public class CollectionField extends BaseField<List<View>, Object>
        implements CollectionFieldInterface<List<View>, Object>, NonViewValueInterface {
    private String name;
    private Map<String, FieldInterface> fields;
    private Map<String, Object> noViewValues;

    public CollectionField(String tag) {
        this(tag, true);
    }

    public CollectionField(String name, boolean isEditable) {
        super(isEditable);
        this.name = name;
        noViewValues = new HashMap<>();
        fields = new LinkedHashMap<>();
    }

    @Override
    public void addField(String name, View view) {
        addField(name, view, true);
    }

    @Override
    public void addField(FieldInterface field) {
        field.setForm(getForm());
        fields.put(field.getName(), field);
    }

    @Override
    public void addField(String name, View view, boolean editable) {
        ViewField field = new ViewField(name, view);
        field.setIsEditable(editable);
        field.setForm(getForm());
        fields.put(name, field);
    }

    @Override
    public Map<String, FieldInterface> getFields() {
        return fields;
    }

    @Override
    public Map<String, Object> getValue() throws FormException {
        Map<String, Object> vals = new HashMap<>(noViewValues);
        for (String name : fields.keySet()) {
            vals.put(name, fields.get(name).getValue());
        }
        return vals;
    }

    @Override
    public void setValue(Object o) throws FormException {
        if (o instanceof List) {
            int index = 0;
            FieldInterface field;
            for (String name : fields.keySet()) {
                field = fields.get(name);
                if (field.isEditable() && ((List) o).size() > index) {
                    field.setValue(((List) o).get(index));
                }
                index++;
            }
        } else if (o instanceof Map) {
            FieldInterface field;
            for (String name : fields.keySet()) {
                field = fields.get(name);
                if (field.isEditable() && ((Map) o).containsKey(name)) {
                    field.setValue(((Map) o).get(name));
                }
            }
        } else {
            throw new FormException(
                    "Set value expects an instance of (List or Map) got :: "
                            + o.getClass());
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<View> getView() throws FormException {
        List<View> views = new ArrayList<>();
        for (FieldInterface field : fields.values()) {
            views.add((View) field.getView());
        }
        return views;
    }

    @Override
    public void setForm(FormInterface form) {
        super.setForm(form);
        for (FieldInterface field : fields.values()) {
            field.setForm(getForm());
        }
    }


    @Override
    public void addNonViewValue(String fieldName, Object value) {
        noViewValues.put(fieldName, value);
    }

    @Override
    public void removeNonViewValue(String fieldName) {
        if (noViewValues.containsKey(fieldName)) {
            noViewValues.remove(fieldName);
        }
    }

}

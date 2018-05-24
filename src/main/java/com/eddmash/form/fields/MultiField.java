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
import com.eddmash.form.NonViewValueInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This fields deals with multi views but they are each treated as one.
 * <p>
 * This mean the values returned are for those fields that have values, the setting also
 * happens to those fields whose data is provided.
 */
public class MultiField extends BaseField<List<View>, Map>
        implements MultiFieldInterface, NonViewValueInterface {

    private final String name;
    private Map<String, FieldInterface> fields;
    private Map<String, Object> noViewValues;

    public MultiField(String name, boolean isEditable) {
        super(isEditable);
        this.name = name;
        fields = new HashMap<>();
        noViewValues = new HashMap<>();
    }

    public MultiField(String name) {
        this(name, true);
    }

    @Override
    public List<FieldInterface> getFields() {
        return new ArrayList<>(fields.values());
    }

    @Override
    public FieldInterface getField(String id) throws FormException {
        if (!fields.containsKey(id)) {
            throw new FormException("Trying to access a non existent field");
        }
        return fields.get(id);
    }

    @Override
    public void addView(String id, View view) {
        fields.put(id.trim().toLowerCase(), new ViewField(name, view));
    }

    @Override
    public void removeView(String id) {
        if (fields.containsKey(id)) {
            fields.remove(id);
        }
    }

    @Override
    public Map getValue() throws FormException {
        Map<String, Object> values = new HashMap<>(noViewValues);
        for (String v : fields.keySet()) {
            values.put(v, fields.get(v).getValue());
        }
        return values;
    }

    @Override
    public void setValue(Map o) throws FormException {

        for (String v : fields.keySet()) {
            if (o.containsKey(v.trim().toLowerCase())) {
                fields.get(v).setValue(String.valueOf(o.get(v)));
            }
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<View> getView() throws FormException {
        List<View> values = new ArrayList<>();
        for (String v : fields.keySet()) {
            values.add((View) fields.get(v).getView());
        }
        return values;
    }

    @Override
    public int getChildCount() {
        return fields.size();
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

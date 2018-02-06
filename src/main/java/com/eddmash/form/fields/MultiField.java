package com.eddmash.form.fields;
/*
* This file is part of the mfivms_malawi_registration_and package.
* 
* (c) Eddilbert Macharia (http://eddmash.com)<edd.cowan@gmail.com>
*
* For the full copyright and license information, please view the LICENSE
* file that was distributed with this source code.
*/

import android.util.Log;
import android.view.View;

import com.eddmash.form.FormException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This fields deals with multi views but they are each treated as one.
 * <p>
 * This mean the values return are for those views that have values, the setting also happens to
 * those views who data is provided.
 */
public class MultiField extends BaseField implements MultiFieldInterface {

    private final String name;
    private Map<View, FieldInterface> views;

    public MultiField(String name, boolean isEditable) {
        super(isEditable);
        this.name = name;
        views = new HashMap<>();
    }

    public MultiField(String name) {
        this(name, true);
    }

    @Override
    public List<View> getViews() {
        return new ArrayList<>(views.keySet());
    }

    @Override
    public FieldInterface getField(View view) throws FormException {
        if (!views.containsKey(view)) {
            throw new FormException("Trying to access a non existent view");
        }
        return views.get(view);
    }

    @Override
    public void addView(View view) {
        Log.e(getClass().getSimpleName(), name + " ADDED ");
        views.put(view, new ViewField(name, view));
    }

    @Override
    public void removeView(View view) {
        if (views.containsKey(view)) {
            views.remove(view);
        }
    }

    @Override
    public Object getValue() throws FormException {
        List values = new ArrayList();
        for (View v : views.keySet()) {
            values.add(views.get(v).getView());
        }
        return values;
    }

    @Override
    public void setValue(Object o) throws FormException {
        for (View v : views.keySet()) {
            views.get(v).setValue(o);
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Object getView() throws FormException {
        throw new FormException("makeView() not supported on " + this.getClass().getName());
    }
}

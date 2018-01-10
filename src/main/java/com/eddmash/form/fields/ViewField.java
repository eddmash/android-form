package com.eddmash.form.fields;
/*
* This file is part of the Tools package.
* 
* (c) Eddilbert Macharia (http://eddmash.com)<edd.cowan@gmail.com>
*
* For the full copyright and license information, please view the LICENSE
* file that was distributed with this source code.
*/

import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.eddmash.form.FormException;
import com.eddmash.views.CollectionView;

public class ViewField extends BaseField {
    private String name;
    private View view;

    public ViewField(String name, View view) {
        this(name, view, true);
    }

    public ViewField(String name, View view, boolean isEditable) {
        super(isEditable);
        this.name = name;
        this.view = view;
        setIsEditable((view instanceof EditText ||
                view instanceof Spinner ||
                view instanceof CompoundButton));
    }

    @Override
    public Object getValue() throws FormException {

        if (view instanceof CompoundButton) {
            return ((CompoundButton) view).isChecked();
        }
        if (view instanceof TextView) {
            return ((TextView) view).getText();
        }
        if (view instanceof Spinner) {
            return ((Spinner) view).getSelectedItem();
        }

        // assumes CollectionView
        if (view instanceof CollectionView) {
            return ((CollectionView) view).getValue();
        }
        throw new FormException("Cannot determine value for the field " + getName());
    }

    @Override
    public void setValue(Object val) throws FormException {
        if (view instanceof EditText) {
            if (val == null) {
                ((EditText) view).setText(null);
            } else {
                ((EditText) view).setText(String.valueOf(val));
            }
        } else if (view instanceof Spinner) {
            if (val != null) {
                ((Spinner) view).setSelection(Integer.parseInt(String.valueOf(val)));
            } else {
                view.setSelected(false);
            }
        } else if (view instanceof CompoundButton) {
            if (val == null) {
                ((CompoundButton) view).setChecked(false);
            } else {
                ((CompoundButton) view).setChecked(Boolean.valueOf(val.toString()));
            }
        } else {

            throw new FormException(String.format("Setting value for field '%s' of type not yet " +
                    "supported '%s' " +
                    " ", getName(), val.getClass().getName()));
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Object getView() {
        return view;
    }

    public void setIsEditable(boolean isEditable) {
        this.isEditable = isEditable;
    }

}

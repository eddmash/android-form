package com.eddmash.form.collection;
/*
* This file is part of the Tools package.
* 
* (c) Eddilbert Macharia (http://eddmash.com)<edd.cowan@gmail.com>
*
* For the full copyright and license information, please view the LICENSE
* file that was distributed with this source code.
*/

import android.util.Log;

import com.eddmash.form.FormException;
import com.eddmash.validation.ValidatorInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Use this class when you want to deal on multiple forms all at once.
 */
public class FormCollection implements FormCollectionInterface {
    private Map<String, InnerFormInterface> forms;
    private ValidatorInterface validator;

    public FormCollection(ValidatorInterface validator) {
        this.validator = validator;
        forms = new HashMap<>();
    }

    @Override
    public void addForm(InnerFormInterface form) throws FormException {
        if (forms.containsKey(form.getIdentifier())) {
            throw new FormException("Trying to add form with an identifier that already in use");
        }
        forms.put(form.getIdentifier(), form);
        ((InnerForm) form).setParent(this);
        validator.addValidator(form.getValidator());
    }

    @Override
    public void removeForm(InnerFormInterface form) {
        if (forms.containsKey(form.getIdentifier())) {
            forms.remove(form.getIdentifier());

        }
    }

    @Override
    public InnerFormInterface getForm(String identifier) throws FormException {
        if (!forms.containsKey(identifier)) {
            throw new FormException("Form with identifer " + identifier + " does not exist");
        }
        return forms.get(identifier);
    }

    private String getTag() {
        return getClass().getName();
    }

    @Override
    public boolean isValid() {
        return validator.validate();
    }

    @Override
    public ValidatorInterface getValidator() {
        return validator;
    }

    @Override
    public boolean save() throws FormException {
        boolean save = false;
        Log.e(getTag(), "SAVING FORMS :: "+getSortedForms());
        for (String name : getSortedForms()) {
            Log.e(getTag(), "SAVING " + name + " STATUS " + save);
            InnerFormInterface form = this.getForm(name);
            save = form.save();
            Log.e(getTag(), "SAVING " + name + " STATUS " + save);
//            if (!save){
//                return false;
//            }
        }
        return true;
    }

    private List<String> getSortedForms() {
        List<String> sorted = new ArrayList<>();
        List<String> dependencies;
        for (String name : forms.keySet()) {
            InnerFormInterface form = forms.get(name);
            dependencies = new ArrayList<>(Arrays.asList(form.requires()));
            for (String depends : dependencies) {
                if (!sorted.contains(depends)) {
                    sorted.add(depends); //todo need to serious sorting
                }
            }
            sorted.add(form.getIdentifier());
        }

        return sorted;
    }
}

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

import org.json.JSONArray;

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
        Log.e(getTag(), "SAVING FORMS :: " + getSortedForms());
        for (String name : getSortedForms()) {
            Log.e(getTag(), "SAVING " + name + " STATUS " + save);
            InnerFormInterface form = this.getForm(name);
            form.save();
            Log.e(getTag(), "SAVING " + name + " STATUS " + save);
        }
        return true;
    }

    private List<String> getSortedForms() throws FormException {

        Map<String, List> depsGraph = new HashMap<>();
        List<String> dependencies;
        for (String name : forms.keySet()) {
            InnerFormInterface form = forms.get(name);
            dependencies = new ArrayList<>(Arrays.asList(form.requires()));
            depsGraph.put(name, dependencies);
            for (String depends : dependencies) {
                if (!depsGraph.containsKey(depends)) {
                    depsGraph.put(depends, new ArrayList());
                }
            }

        }

        return toposort(depsGraph);
    }

    private List<String> toposort(Map<String, List> depsGraph) throws FormException {
        List<String> itemDependencies;
        List<String> noDependencies;
        Map<String, List> newDeps;
        List<String> sorted = new ArrayList<>();
        Map<String, List> data = depsGraph;

        while (!data.isEmpty()) {
            // get items without any dependencies
            noDependencies = new ArrayList<>();
            for (String item : data.keySet()) {
                if (depsGraph.get(item).isEmpty()) {
                    noDependencies.add(item);
                }
            }

            if (noDependencies.isEmpty()) {
                String failed = "";
                failed = new JSONArray(noDependencies).toString();

                throw new FormException(String.format(
                        "Cyclic dependency on topological sort %s", failed));
            }
            sorted.addAll(noDependencies);

            // create new graph , removeing those items that have already been sorted.
            newDeps = new HashMap<>();
            for (String item : data.keySet()) {
                if (!sorted.contains(item)) {
                    // remove the already sorted parent from the list of dependencies
                    // of current item.
                    itemDependencies = data.get(item);
                    itemDependencies.removeAll(noDependencies);
                    newDeps.put(item, itemDependencies);
                }
            }
            data = newDeps;
        }
        return sorted;
    }
}

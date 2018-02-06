package com.eddmash.form;
/*
* This file is part of the Tools package.
* 
* (c) Eddilbert Macharia (http://eddmash.com)<edd.cowan@gmail.com>
*
* For the full copyright and license information, please view the LICENSE
* file that was distributed with this source code.
*/

import android.view.View;

import com.eddmash.form.fields.FieldInterface;
import com.eddmash.validation.checks.CheckInterface;

import java.util.List;
import java.util.Map;

public interface FormInterface {

    /**
     * A unique identifier for this form.
     *
     * @return
     */
    String getIdentifier();

    void addField(FieldInterface field);

    void addField(String colName, View view);

    void removeField(String replace);

    void removeField(FieldInterface field);

    Map<String, FieldInterface> getFields();

    FieldInterface getField(String fieldName) throws FormException;

    void setData(Map data) throws FormException;

    Map<String, Object> getValues() throws FormException;

    Object getValue(String fieldName) throws FormException;

    void setValue(String fieldName, Object value);

    /**
     * THis is the right place to perform form wide validations.
     * That is validating fields against each other, also validate against parent form fields.
     * <p>
     * At this point you have access to the getValues() of both parent form and current form
     * you can use this values to compare against.
     * <p>
     * The recommend approach is to a create check that implements FormAwareInterface and add it to
     * the validator.
     * <p>
     * This method is invoked before the field specific validations have been run.
     */
    void validate();

    /**
     * This performs actual validations.
     * This runs the validations on the validator then runs the validations on the validate() method.
     *
     * @return
     */
    boolean isValid();

    /**
     * This is where you should put you saving logic.
     * <p>
     * throw FormException if validation fails.
     *
     * @throws FormException
     */
    void save() throws FormException;


    /**
     * Add a validation check.
     *
     * @param check
     */
    void addCheck(CheckInterface check);

    /**
     * Disable a validation check
     *
     * @param check
     */
    void disableCheck(CheckInterface check);

    /**
     * Returns all the errors on the form after validation.
     * <p>
     *
     * @return the key is the form identifier and the values is a list of all the validation errors
     * related with the form.
     */
    Map<String, List> getErrors();
}

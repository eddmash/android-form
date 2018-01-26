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
import com.eddmash.validation.ValidatorInterface;
import com.eddmash.validation.checks.CheckInterface;

import java.util.Map;

public interface FormInterface {

    ValidatorInterface getValidator();

    void addField(FieldInterface field);

    void addField(String colName, View view);

    void addField(String name, View view, CheckInterface check);

    void removeField(String replace);

    void removeField(FieldInterface field);

    Map<String, FieldInterface> getFields();

    FieldInterface getField(String fieldName) throws FormException;

    void setData(Map data) throws FormException;

    Map<String, Object> getValues() throws FormException;

    Object getValue(String fieldName) throws FormException;

    void setValue(String fieldName, Object value);

    boolean isValid();

    boolean save();
}

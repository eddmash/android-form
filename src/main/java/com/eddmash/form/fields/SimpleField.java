package com.eddmash.form.fields;
/*
* This file is part of the androidcomponents package.
* 
* (c) Eddilbert Macharia (http://eddmash.com)<edd.cowan@gmail.com>
*
* For the full copyright and license information, please view the LICENSE
* file that was distributed with this source code.
*/

import com.eddmash.form.FormException;

public class SimpleField extends BaseField<Object, Object> {

    private String name;
    private Object value;

    public SimpleField(String name, Object value) {
        this(name, value, false);
    }

    public SimpleField(String name, Object value, boolean isEditable) {
        super(isEditable);
        this.name = name;
        this.value = value;
    }

    @Override
    public Object getValue() throws FormException {
        return value;
    }

    @Override
    public void setValue(Object o) throws FormException {
        this.value = o;
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

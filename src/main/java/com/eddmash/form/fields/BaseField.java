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
import com.eddmash.form.FormInterface;

public abstract class BaseField<V, E> implements FieldInterface<V, E> {

    protected FormInterface form;
    protected boolean isEditable;

    BaseField(boolean isEditable) {
        this.isEditable = isEditable;
    }

    @Override
    public FormInterface getForm() {
        return form;
    }

    @Override
    public void setForm(FormInterface form) {
        this.form = form;
    }

    @Override
    public boolean isEditable() {
        return this.isEditable;
    }

    @Override
    public abstract V getView() throws FormException;

    @Override
    public abstract E getValue() throws FormException;

    @Override
    public abstract void setValue(E o) throws FormException;
}

package com.eddmash.form.fields;
/*
* This file is part of the Ziamismalawi package.
* 
* (c) Eddilbert Macharia (http://eddmash.com)<edd.cowan@gmail.com>
*
* For the full copyright and license information, please view the LICENSE
* file that was distributed with this source code.
*/

import com.eddmash.form.FormInterface;

public abstract class BaseField implements FieldInterface {

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
    public FieldInterface setForm(FormInterface form) {
        this.form = form;
        return this;
    }

    @Override
    public boolean isEditable() {
        return this.isEditable;
    }
}

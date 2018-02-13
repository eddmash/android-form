package com.eddmash.form.collection;
/*
* This file is part of the androidcomponents package.
* 
* (c) Eddilbert Macharia (http://eddmash.com)<edd.cowan@gmail.com>
*
* For the full copyright and license information, please view the LICENSE
* file that was distributed with this source code.
*/

import com.eddmash.form.Form;
import com.eddmash.form.FormInterface;
import com.eddmash.validation.ValidatorInterface;

/**
 * This is basically {@link FormInterface form }that has the capability of being used with a form
 * collection.
 */
public abstract class InnerForm extends Form implements InnerFormInterface {
    protected FormCollectionInterface form;

    public InnerForm() {
        super();
    }

    public InnerForm(ValidatorInterface validator) {
        super(validator);
    }


    public void setParent(FormCollectionInterface form) {

        this.form = form;
    }

    @Override
    public FormCollectionInterface getParent() {
        return form;
    }
}

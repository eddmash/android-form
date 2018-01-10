package com.eddmash.form.collection;
/*
* This file is part of the Tools package.
* 
* (c) Eddilbert Macharia (http://eddmash.com)<edd.cowan@gmail.com>
*
* For the full copyright and license information, please view the LICENSE
* file that was distributed with this source code.
*/

import com.eddmash.form.FormException;
import com.eddmash.validation.ValidatorInterface;

public interface FormCollectionInterface {

    void addForm(InnerFormInterface form) throws FormException;

    void removeForm(InnerFormInterface form);

    InnerFormInterface getForm(String identifier) throws FormException;

    boolean isValid();

    boolean save() throws FormException;

    ValidatorInterface getValidator();
}

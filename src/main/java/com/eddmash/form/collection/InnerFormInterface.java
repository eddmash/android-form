package com.eddmash.form.collection;
/*
* This file is part of the Tools package.
* 
* (c) Eddilbert Macharia (http://eddmash.com)<edd.cowan@gmail.com>
*
* For the full copyright and license information, please view the LICENSE
* file that was distributed with this source code.
*/

import com.eddmash.form.FormInterface;

/**
 * This is basically {@link FormInterface form }that has the capability of being used with a form
 * collection.
 * <p>
 * This form also has the added capability of depending on another form thats in the same
 * collection as the one it belongs to.
 */
public interface InnerFormInterface extends FormInterface {

    /**
     * An string array of other inner forms that this form should depend on i.e. those forms should
     * be validated before this during the validation stage and should be saved before this is
     * saved.
     *
     * @return
     */
    String[] requires();

    /**
     * The collection form in which this form belongs to.
     *
     * @return
     */
    FormCollectionInterface getParent();
}

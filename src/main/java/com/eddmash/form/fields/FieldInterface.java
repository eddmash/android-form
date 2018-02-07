package com.eddmash.form.fields;
/*
* This file is part of the Tools package.
* 
* (c) Eddilbert Macharia (http://eddmash.com)<edd.cowan@gmail.com>
*
* For the full copyright and license information, please view the LICENSE
* file that was distributed with this source code.
*/

import android.view.View;

import com.eddmash.form.FormAwareInterface;
import com.eddmash.form.FormException;
import com.eddmash.form.FormInterface;

import java.util.List;

/**
 * This provides a consitent way of dealing with the different views provided by android.
 */
public interface FieldInterface<T, E> extends FormAwareInterface {

    /**
     * Returns the value of the view
     *
     * @return Object
     * @throws FormException
     */
    E getValue() throws FormException;

    /**
     * Set view value.
     *
     * @param o
     * @throws FormException
     */
    void setValue(E o) throws FormException;

    /**
     * A name that uniquely identify the view. this is use when you need to pull a specific field
     * from the form instance.
     *
     * @return name
     */
    String getName();

    /**
     * The actual view object(s) we are operating on.
     * <p>
     * Note this may return a list of view objects in case of CollectionField
     *
     * @return a view instance
     * @throws FormException in case it not possible to retrieve the view object
     */
    T getView() throws FormException;

    /**
     * Is the view editable, this tells the form not to set values for the view and also tells
     * the populator not to populate it.
     *
     * @return true if editable, false otherwise
     */
    boolean isEditable();

    /**
     * The form instance this field is attached to.
     *
     * @return form
     */
    FormInterface getForm();


}

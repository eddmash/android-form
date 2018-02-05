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

/**
 * Use this class when you want to deal on multiple forms all at once.
 */
public interface FormCollectionInterface {

    /**
     * Add a form into the collection.
     *
     * @param form
     * @throws FormException
     */
    void addForm(InnerFormInterface form) throws FormException;

    /**
     * REmove a from the collection.
     *
     * @param form
     */
    void removeForm(InnerFormInterface form);

    /**
     * Get a form in the collection by its identifier.
     *
     * @param identifier
     * @return
     * @throws FormException
     */
    InnerFormInterface getForm(String identifier) throws FormException;

    /**
     * Entry point for validation of all the innerforms on this collection.
     * <p>
     * Runs validation for each of the inner forms.
     *
     * @return
     */
    boolean isValid();

    /**
     * The entry point of form saving.
     * <p>
     * This method calls the save() of each innerform attached to this collection
     * <p>
     * Wrap this method in a transaction to ensure if any of the inner form fails to save, All
     * the other innerforms arent saved. for consistency sake.
     *
     * @return
     * @throws FormException
     */
    boolean save() throws FormException;

    /**
     * The validator this collection will be using to validate the inner forms.
     * <p>
     * This is basically a parent validator which calls the individual validators bound to each
     * of the inner forms.
     *
     * @return
     */
    ValidatorInterface getValidator();
}

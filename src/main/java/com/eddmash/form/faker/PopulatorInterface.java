package com.eddmash.form.faker;
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
import com.eddmash.form.faker.provider.ProviderInterface;
import com.eddmash.form.fields.FieldInterface;

/**
 * Its responsible for populating the {@link FormInterface} or {@link FieldInterface} provided.
 * <p>
 * The populator uses {@link ProviderInterface providers} to populate each field presented to the
 * populator.
 */
public interface PopulatorInterface {
    /**
     * Set the provider to use the populator a specific field.
     *
     * @param name     the name of the field that will use the provider given.
     * @param provider the provider to use instead of the default onces.
     */
    void setProvider(String name, ProviderInterface provider);
    void setProvider(Class clazz, ProviderInterface provider);

    /**
     * Tell the populator to start the population on the specified form.
     *
     * @param form
     * @throws FormException
     */
    void populate(FormInterface form) throws FormException;

    /**
     * Tell the populator to start the population on the specified field.
     *
     * @param field
     * @throws FormException
     */
    void populate(FieldInterface field) throws FormException;
}

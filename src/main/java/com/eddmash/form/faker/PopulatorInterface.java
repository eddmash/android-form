package com.eddmash.form.faker;
/*
* This file is part of the Tools package.
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

public interface PopulatorInterface {
    void setFieldPopulator(String name, ProviderInterface provider);
    void populate(FormInterface form) throws FormException;
    void populate(FieldInterface field) throws FormException;
}

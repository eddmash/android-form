package com.eddmash.form.faker.provider;
/*
* This file is part of the Tools package.
* 
* (c) Eddilbert Macharia (http://eddmash.com)<edd.cowan@gmail.com>
*
* For the full copyright and license information, please view the LICENSE
* file that was distributed with this source code.
*/

import com.eddmash.form.faker.PopulatorInterface;

/**
 * This class is responsible for generating data.
 */
public interface ProviderInterface {
    ProviderInterface setPopulator(PopulatorInterface populator);

    String getIdentifier();

    String generate();
}

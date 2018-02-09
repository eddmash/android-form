package com.eddmash.form.faker.provider;
/*
* This file is part of the Tools package.
* 
* (c) Eddilbert Macharia (http://eddmash.com)<edd.cowan@gmail.com>
*
* For the full copyright and license information, please view the LICENSE
* file that was distributed with this source code.
*/

/**
 * This class is responsible for generating data.
 * <p>
 * The default implementation {@link Provider} uses the {@link ProviderInterface#generate()} to
 * generate the actual data and then use {@link ProviderInterface#getData()} to format the data.
 * <p>
 * That is each method on the default providers is used a setter of the type of data to generate.
 */
public interface ProviderInterface {

    /**
     * This should return the default values the populator will use.
     *
     * @return
     */
    String generate();


    /**
     * Returns the generated value by the provider.
     *
     * @return
     */
    String getData();
}

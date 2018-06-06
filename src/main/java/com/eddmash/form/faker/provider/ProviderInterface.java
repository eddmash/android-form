package com.eddmash.form.faker.provider;
/*
* This file is part of the androidcomponents package.
* 
* (c) Eddilbert Macharia (http://eddmash.com)<edd.cowan@gmail.com>
*
* For the full copyright and license information, please view the LICENSE
* file that was distributed with this source code.
*/

import android.view.View;

/**
 * This class is responsible for generating data.
 * <p>
 * The default implementation {@link Provider} uses the {@link ProviderInterface#generate(View)} to
 * generate the actual data and then use {@link ProviderInterface#getData(View)} to format the data.
 * <p>
 * That is each method on the default providers is used a setter of the type of data to generate.
 */
public interface ProviderInterface {

    /**
     * This should return the values the populator will use.
     *
     * This values are use in the parsing process, this method maybe invoked several times
     * depending on the format the of data required.
     *
     * @return generated value
     * @param view this the view for which the data is being generated.
     */
    String generate(View view);


    /**
     * Returns the generated value by the provider.
     *
     * @return generated value
     * @param view this the view for which the data is being generated.
     */
    String getData(View view);
}

package com.eddmash.form.faker.provider;
/*
* This file is part of the androidcomponents package.
* 
* (c) Eddilbert Macharia (http://eddmash.com)<edd.cowan@gmail.com>
*
* For the full copyright and license information, please view the LICENSE
* file that was distributed with this source code.
*/

import com.eddmash.form.faker.PopulatorInterface;

public class TelephoneProvider extends Provider {

    public TelephoneProvider(PopulatorInterface populator) {
        this(populator, "(+###) ### ### ###");
    }

    public TelephoneProvider(PopulatorInterface populator, String format) {
        super(populator, format);
    }

    public String generate() {
        return String.valueOf(randomInt(1, 9));
    }

}

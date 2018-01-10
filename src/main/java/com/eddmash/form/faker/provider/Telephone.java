package com.eddmash.form.faker.provider;
/*
* This file is part of the Tools package.
* 
* (c) Eddilbert Macharia (http://eddmash.com)<edd.cowan@gmail.com>
*
* For the full copyright and license information, please view the LICENSE
* file that was distributed with this source code.
*/

import com.eddmash.form.faker.Callback;

public class Telephone extends Provider {

    public Telephone() {
        format = "(+###) ### ### ###";
    }

    public String generate() {
        return parseFormat(format, new Callback() {
            @Override
            public String invoke() {
                return String.valueOf(randomInt(1,9));
            }
        });
    }

}

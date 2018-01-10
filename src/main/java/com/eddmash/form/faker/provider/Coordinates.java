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

public class Coordinates extends Provider {
    String LONGITUDE = "longitude";
    String LATITUDE = "latitude";
    private String type;

    public Coordinates() {
        type = LATITUDE;
    }

    public ProviderInterface getLongitude() {
        type = LONGITUDE;
        return this;
    }

    public ProviderInterface getLatitude() {
        type = LATITUDE;
        return this;
    }

    @Override
    public String generate() {
        if (type.equals(LONGITUDE)) {
            return parseFormat(format, new Callback() {
                @Override
                public String invoke() {
                    return String.valueOf(randomDouble(-180, 180));
                }
            });
        }
        return parseFormat(format, new Callback() {
            @Override
            public String invoke() {
                return String.valueOf(randomDouble(-90, 90));
            }
        });
    }

}

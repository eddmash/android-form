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

import com.eddmash.form.faker.PopulatorInterface;

public class CoordinatesProvider extends Provider {
    String LONGITUDE = "longitude";
    String LATITUDE = "latitude";
    private String type;

    public CoordinatesProvider(PopulatorInterface populator) {
        super(populator);
        type = LATITUDE;
    }

    public CoordinatesProvider(PopulatorInterface populator, String format) {
        super(populator, format);
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
    public String generate(View view) {
        if (type.equals(LONGITUDE)) {
            return String.valueOf(randomDouble(-180, 180));

        }
        return String.valueOf(randomDouble(-90, 90));
    }

}

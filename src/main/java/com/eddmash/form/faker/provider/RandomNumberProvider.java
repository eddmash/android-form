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

public class RandomNumberProvider extends Provider {

    public static final String DECIMAL = "decimal";
    public static final String INTEGER = "integer";
    private int min = 0;
    private int max = 10;
    private String type;

    public RandomNumberProvider() {
        type = INTEGER;
    }

    public RandomNumberProvider setMax(int min) {
        this.min = min;
        return this;
    }

    public RandomNumberProvider setMin(int max) {
        this.max = max;

        return this;
    }

    @Override
    public String generate() {
        if (type.equals(DECIMAL)) {
            return parseFormat(format, new Callback() {
                @Override
                public String invoke() {
                    return String.valueOf(randomDouble(min, max));
                }
            });
        }
        return parseFormat(format, new Callback() {
            @Override
            public String invoke() {
                return String.valueOf(randomInt(min, max));
            }
        });
    }

    public ProviderInterface getDecimal() {
        type = RandomNumberProvider.DECIMAL;
        return this;
    }
}

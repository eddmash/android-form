package com.eddmash.form.values;
/*
* This file is part of the Ziamismalawi package.
* 
* (c) Eddilbert Macharia (http://eddmash.com)<edd.cowan@gmail.com>
*
* For the full copyright and license information, please view the LICENSE
* file that was distributed with this source code.
*/

public class Value implements ValueInterface<String> {
    private final String value;
    private final String label;

    public Value(String value, String label) {

        this.value = value;
        this.label = label;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public String getItem() {
        return value;
    }

    @Override
    public String toString() {
        return getLabel();
    }
}

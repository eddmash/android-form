package com.eddmash.form.values;
/*
* This file is part of the androidcomponents package.
* 
* (c) Eddilbert Macharia (http://eddmash.com)<edd.cowan@gmail.com>
*
* For the full copyright and license information, please view the LICENSE
* file that was distributed with this source code.
*/

/**
 * {@link ValueInterface }
 * <p>
 * This basically deals with simples string values.
 */
public class SimpleValue implements ValueInterface<String> {
    private final String value;
    private final String label;

    public SimpleValue(String value, String label) {

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

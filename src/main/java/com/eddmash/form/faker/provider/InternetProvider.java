package com.eddmash.form.faker.provider;
/*
* This file is part of the androidcomponents package.
* 
* (c) Eddilbert Macharia (http://eddmash.com)<edd.cowan@gmail.com>
*
* For the full copyright and license information, please view the LICENSE
* file that was distributed with this source code.
*/

import com.eddmash.form.faker.FakerException;
import com.eddmash.form.faker.PopulatorInterface;

public class InternetProvider extends Provider {
    private static final String EMAIL = "email";
    private static final String DOMAIN = "domain";
    private static final String TLD = "tld";
    private String type;

    public InternetProvider(PopulatorInterface populator) {
        super(populator);
    }

    public InternetProvider(PopulatorInterface populator, String format) {
        super(populator, format);
    }


    public InternetProvider getEmail() {
        type = EMAIL;
        return this;
    }

    public InternetProvider getDomain() {
        type = DOMAIN;
        return this;
    }

    public InternetProvider getTld() {
        type = TLD;
        return this;
    }


    public String generate() {
        if (type.equals(DOMAIN)) {
            return getPersonName() + "." + this.getTld();
        }
        if (type.equals(TLD)) {
            try {
                return randomElement(this.tlds());
            } catch (FakerException e) {
                e.printStackTrace();
            }
            return "com";
        }
        return this.getPersonName() + "@" + this.getDomain();
    }

    private String[] tlds() {
        return new String[]{
                "com", "com", "com", "com", "com", "com", "biz", "info", "net", "org"
        };
    }
}

package com.eddmash.form.faker.provider;
/*
* This file is part of the Tools package.
* 
* (c) Eddilbert Macharia (http://eddmash.com)<edd.cowan@gmail.com>
*
* For the full copyright and license information, please view the LICENSE
* file that was distributed with this source code.
*/

import com.eddmash.form.faker.FakerException;

public class InternetProvider extends Provider {
    public static final String EMAIL = "email";
    public static final String DOMAIN = "domain";
    public static final String TLD = "tld";
    private String type;

    public InternetProvider() {
        type = EMAIL;
    }

    private String getEmail() {
        return this.getPersonName(Person.FIRSTNAME) + "@" + this.getDomain();
    }

    private String getDomain() {
        return getPersonName(Person.LASTNAME) + "." + this.getTld();
    }

    private String getTld() {
        try {
            return randomElement(this.tlds());
        } catch (FakerException e) {
            e.printStackTrace();
        }
        return "com";
    }


    public String generate() {
        if (type.equals(DOMAIN)){
            return this.getDomain();
        }
        if (type.equals(TLD)){
            return this.getTld();
        }
        return this.getEmail();
    }

    public InternetProvider setType(String type) {
        this.type = type;
        return this;
    }

    private String[] tlds() {
        return new String[]{
                "com", "com", "com", "com", "com", "com", "biz", "info", "net", "org"
        };
    }
}

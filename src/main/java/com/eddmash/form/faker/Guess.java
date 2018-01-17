package com.eddmash.form.faker;
/*
* This file is part of the Tools package.
* 
* (c) Eddilbert Macharia (http://eddmash.com)<edd.cowan@gmail.com>
*
* For the full copyright and license information, please view the LICENSE
* file that was distributed with this source code.
*/

import android.view.View;
import android.widget.EditText;

import com.eddmash.form.faker.provider.DateProvider;
import com.eddmash.form.faker.provider.InternetProvider;
import com.eddmash.form.faker.provider.LoremProvider;
import com.eddmash.form.faker.provider.ProviderInterface;
import com.eddmash.views.DatePickerView;
import com.eddmash.form.faker.provider.Coordinates;
import com.eddmash.form.faker.provider.LocationsProvider;
import com.eddmash.form.faker.provider.Person;
import com.eddmash.form.faker.provider.RandomNumberProvider;
import com.eddmash.form.faker.provider.Telephone;

import static android.text.InputType.TYPE_CLASS_DATETIME;
import static android.text.InputType.TYPE_CLASS_NUMBER;
import static android.text.InputType.TYPE_CLASS_TEXT;
import static android.text.InputType.TYPE_DATETIME_VARIATION_DATE;
import static android.text.InputType.TYPE_DATETIME_VARIATION_NORMAL;
import static android.text.InputType.TYPE_DATETIME_VARIATION_TIME;
import static android.text.InputType.TYPE_NUMBER_FLAG_DECIMAL;
import static android.text.InputType.TYPE_NUMBER_FLAG_SIGNED;
import static android.text.InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS;
import static android.text.InputType.TYPE_TEXT_VARIATION_PERSON_NAME;
import static android.text.InputType.TYPE_TEXT_VARIATION_POSTAL_ADDRESS;

class Guess {

    private PopulatorInterface populator;

    Guess(PopulatorInterface populator) {
        this.populator = populator;
    }

    public String guess(String name, View view) throws FakerException {
        ProviderInterface val = guessByName(name);
        if (val == null) {
            val = guessByType(name, view);
        }
        val.setPopulator(populator);
        return val.generate();
    }

    /**
     * Guess value base on the name of the field.
     *
     * @param name
     * @return
     * @throws FakerException
     */
    private ProviderInterface guessByName(String name) throws FakerException {
        ProviderInterface provider = null;
        name = name.replace(" ", "")//remove space
                .replace("_", "") //remove underscore
                .replace("-", "") //remove hyphen
                .toLowerCase();
        switch (name) {
            case "phonenumber":
            case "phone":
            case "telephone":
            case "telnumber":
            case "mobile":
            case "mobilenumber":
                provider = new Telephone();
                break;
            case "email":
            case "emailaddress":
                provider = new InternetProvider();
                break;
            case "firstname":
            case "middlename":
                provider = new Person().getFirstName();
                break;
            case "surname":
            case "lastname":
                provider = new Person().getLastName();
                break;
            case "fullname":
            case "name":
                provider = new Person().getFullName();
                break;
            case "country":
            case "city":
            case "cityname":
            case "village":
            case "villagename":
            case "town":
            case "townname":
                provider = new LocationsProvider().getCity();
                break;
            case "x":
            case "latitude":
                provider = new Coordinates().getLatitude();
                break;
            case "y":
            case "longitude":
                provider = new Coordinates().getLongitude();
                break;
        }

        return provider;
    }

    /**
     * Guess value based on type of view
     *
     * @param name
     * @param field
     * @return
     * @throws FakerException
     */
    private ProviderInterface guessByType(String name, View field) throws FakerException {
        ProviderInterface provider = null;

        if (field instanceof EditText) {
            int type = ((EditText) field).getInputType();

            if (type == (TYPE_CLASS_TEXT | TYPE_TEXT_VARIATION_POSTAL_ADDRESS)) {
                provider = new LocationsProvider().getCity();

            }
            if (type == (TYPE_CLASS_TEXT | TYPE_TEXT_VARIATION_PERSON_NAME)) {
                provider = new LocationsProvider().getCity();
            }
            if (type == (TYPE_CLASS_TEXT | TYPE_TEXT_VARIATION_EMAIL_ADDRESS)) {
                provider = new InternetProvider();
            }
            if (type == (TYPE_CLASS_NUMBER | TYPE_NUMBER_FLAG_DECIMAL)) {
                provider = new RandomNumberProvider().getDecimal();
            }
            if (type == (TYPE_CLASS_NUMBER | TYPE_NUMBER_FLAG_SIGNED) ||
                    type == TYPE_CLASS_NUMBER) {
                provider = new RandomNumberProvider();
            }

            if (type == (TYPE_CLASS_DATETIME | TYPE_DATETIME_VARIATION_DATE)) {
                provider = new DateProvider();
            }

            if (type == (TYPE_CLASS_DATETIME | TYPE_DATETIME_VARIATION_TIME)) {
                provider = new DateProvider().getTime();
            }
            if (type == (TYPE_CLASS_DATETIME | TYPE_DATETIME_VARIATION_NORMAL)) {
                provider = new DateProvider();
            }
        }

        if (field instanceof DatePickerView) {
            provider = new DateProvider().setDateFormat(DatePickerView.DATEFORMAT);
        }

        if (provider == null) {
            provider = new LoremProvider().getWord();
        }
        return provider;
    }
}

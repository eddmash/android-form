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

public class LocationsProvider extends Provider {
    public static final String CITY = "city";
    public static final String COUNTRY = "country";
    public static final String ADDRESS = "address";
    private String type;

    public LocationsProvider(PopulatorInterface populator) {
        super(populator);
    }

    public LocationsProvider(PopulatorInterface populator, String format) {
        super(populator, format);
    }

    private LocationsProvider getAddress() {
        format = "# # #";
        type = ADDRESS;

        return this;
    }

    public LocationsProvider getCity() {
        type = LocationsProvider.CITY;
        return this;
    }

    private String[] countries() {
        return new String[]{
                "Afghanistan", "Albania", "Algeria", "American Samoa", "Andorra", "Angola",
                "Anguilla", "Antarctica (the territory South of 60 deg S)", "Antigua and " +
                "Barbuda", "Argentina", "Armenia", "Aruba", "Australia", "Austria", "Azerbaijan",
                "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize",
                "Benin", "Bermuda", "Bhutan", "Bolivia", "Bosnia and Herzegovina", "Botswana",
                "Bouvet Island (Bouvetoya)", "Brazil", "British Indian Ocean Territory (Chagos " +
                "Archipelago)", "British Virgin Islands", "Brunei Darussalam", "Bulgaria",
                "Burkina Faso", "Burundi",
                "Cambodia", "Cameroon", "Canada", "Cape Verde", "Cayman Islands", "Central " +
                "African Republic", "Chad", "Chile", "China", "Christmas Island", "Cocos " +
                "(Keeling) Islands", "Colombia", "Comoros", "Congo", "Cook Islands", "Costa " +
                "Rica", "Cote d\"Ivoire", "Croatia", "Cuba", "Cyprus", "Czech Republic",
                "Denmark", "Djibouti", "Dominica", "Dominican Republic",
                "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia",
                "Ethiopia",
                "Faroe Islands", "Falkland Islands (Malvinas)", "Fiji", "Finland", "France",
                "French Guiana", "French Polynesia", "French Southern Territories",
                "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Gibraltar", "Greece",
                "Greenland", "Grenada", "Guadeloupe", "Guam", "Guatemala", "Guernsey", "Guinea",
                "Guinea-Bissau", "Guyana",
                "Haiti", "Heard Island and McDonald Islands", "Holy See (Vatican City State)",
                "Honduras", "Hong Kong", "Hungary",
                "Iceland", "India", "Indonesia", "Iran", "Iraq", "Ireland", "Isle of Man",
                "Israel", "Italy",
                "Jamaica", "Japan", "Jersey", "Jordan",
                "Kazakhstan", "Kenya", "Kiribati", "Korea", "Korea", "Kuwait", "Kyrgyz Republic",
                "Lao People\"s Democratic Republic", "Latvia", "Lebanon", "Lesotho", "Liberia",
                "Libyan Arab Jamahiriya", "Liechtenstein", "Lithuania", "Luxembourg",
                "Macao", "Macedonia", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali",
                "Malta", "Marshall Islands", "Martinique", "Mauritania", "Mauritius", "Mayotte",
                "Mexico", "Micronesia", "Moldova", "Monaco", "Mongolia", "Montenegro",
                "Montserrat", "Morocco", "Mozambique", "Myanmar",
                "Namibia", "Nauru", "Nepal", "Netherlands Antilles", "Netherlands", "New " +
                "Caledonia", "New Zealand", "Nicaragua", "Niger", "Nigeria", "Niue", "Norfolk " +
                "Island", "Northern Mariana Islands", "Norway",
                "Oman",
                "Pakistan", "Palau", "Palestinian Territories", "Panama", "Papua New Guinea",
                "Paraguay", "Peru", "Philippines", "Pitcairn Islands", "Poland", "Portugal",
                "Puerto Rico",
                "Qatar",
                "Reunion", "Romania", "Russian Federation", "Rwanda",
                "Saint Barthelemy", "Saint Helena", "Saint Kitts and Nevis", "Saint Lucia",
                "Saint Martin", "Saint Pierre and Miquelon", "Saint Vincent and the Grenadines",
                "Samoa", "San Marino", "Sao Tome and Principe", "Saudi Arabia", "Senegal",
                "Serbia", "Seychelles", "Sierra Leone", "Singapore", "Slovakia (Slovak Republic)" +
                "", "Slovenia", "Solomon Islands", "Somalia", "South Africa", "South Georgia and " +
                "the South Sandwich Islands", "Spain", "Sri Lanka", "Sudan", "Suriname",
                "Svalbard & Jan Mayen Islands", "Swaziland", "Sweden", "Switzerland", "Syrian " +
                "Arab Republic",
                "Taiwan", "Tajikistan", "Tanzania", "Thailand", "Timor-Leste", "Togo", "Tokelau",
                "Tonga", "Trinidad and Tobago", "Tunisia", "Turkey", "Turkmenistan", "Turks and " +
                "Caicos Islands", "Tuvalu",
                "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom", "United States of " +
                "America", "United States Minor Outlying Islands", "United States Virgin " +
                "Islands", "Uruguay", "Uzbekistan",
                "Vanuatu", "Venezuela", "Vietnam",
                "Wallis and Futuna", "Western Sahara",
                "Yemen",
                "Zambia", "Zimbabwe"
        };
    }

    private String[] cityPrefix() {
        return new String[]{
                "North", "East", "West", "South", "New", "Lake", "Port"
        };
    }

    private String[] citySuffix() {
        return new String[]{
                "town", "ton", "land", "ville", "berg", "burgh", "borough", "bury", "view",
                "port", "mouth", "stad", "furt", "chester", "mouth", "fort", "haven", "side",
                "shire"
        };
    }

    @Override
    public String generate() {
        if (type.equals(CITY)) {
            try {
                return getPersonName() + " " + randomElement(citySuffix());
            } catch (FakerException e) {
                e.printStackTrace();
            }
            return "";
        }
        if (type.equals(ADDRESS)) {
            return new RandomNumberProvider(populator, "####").getData();
        }
        try {
            return randomElement(countries());
        } catch (FakerException e) {
            e.printStackTrace();
        }
        return countries()[0];
    }

}

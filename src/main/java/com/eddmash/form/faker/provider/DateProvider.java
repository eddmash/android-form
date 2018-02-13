package com.eddmash.form.faker.provider;
/*
* This file is part of the androidcomponents package.
* 
* (c) Eddilbert Macharia (http://eddmash.com)<edd.cowan@gmail.com>
*
* For the full copyright and license information, please view the LICENSE
* file that was distributed with this source code.
*/

import com.eddmash.form.faker.PopulatorInterface;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class DateProvider extends Provider {
    protected String dateFormat = "yyyy-MM-dd";
    protected String timeFormat = "HH:mm:ss";
    public static final String TODAY = "today";
    public static final String TIME_NOW = "timeNow";
    private String type;

    public DateProvider(PopulatorInterface populator) {
        super(populator);
    }

    public DateProvider(PopulatorInterface populator, String format) {
        super(populator, format);
    }

    public DateProvider getDate() {
        return getDate(timeFormat);
    }

    public DateProvider getDate(String timeFormat) {
        type = TODAY;
        this.timeFormat = timeFormat;
        return this;
    }


    public DateProvider getTime() {
        return getTime(timeFormat);
    }

    public DateProvider getTime(String timeFormat) {
        type = TIME_NOW;
        this.timeFormat = timeFormat;
        return this;
    }


    private String makeDate(String format) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.US);
        return sdf.format(calendar.getTime());
    }

    @Override
    public String generate() {
        if (type.equals(TIME_NOW)) {
            return makeDate(timeFormat);
        }
        return makeDate(dateFormat);
    }

}

package com.eddmash.form.faker.provider;
/*
* This file is part of the Tools package.
* 
* (c) Eddilbert Macharia (http://eddmash.com)<edd.cowan@gmail.com>
*
* For the full copyright and license information, please view the LICENSE
* file that was distributed with this source code.
*/

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class DateProvider extends Provider {
    protected String dateFormat = "yyyy-MM-dd";
    protected String timeFormat = "HH:mm:ss.SSS";
    public static final String TODAY = "today";
    public static final String TIME_NOW = "timeNow";
    private String type;

    public DateProvider() {
        type = TODAY;
    }

    public DateProvider setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
        return this;
    }

    public DateProvider setTimeFormat(String timeFormat) {
        this.timeFormat = timeFormat;
        return this;
    }


    public String today() {
        return getDate(dateFormat);
    }

    public String timeNow() {
        return getDate(timeFormat);
    }


    public String getDate(String format) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.US);
        return sdf.format(calendar.getTime());
    }

    @Override
    public String generate() {
        if (type.equals(TIME_NOW)) {
            return timeNow();
        }
        return today();
    }

    public ProviderInterface getTime() {
        type = TIME_NOW;
        return this;
    }
}

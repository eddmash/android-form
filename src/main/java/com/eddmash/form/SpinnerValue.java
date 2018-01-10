package com.eddmash.form;
/*
* This file is part of the Fivmszm package.
* 
* (c) Eddilbert Macharia (http://eddmash.com)<edd.cowan@gmail.com>
*
* For the full copyright and license information, please view the LICENSE
* file that was distributed with this source code.
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpinnerValue implements SpinnerValueInterface<Map> {
    private Map item;
    private final String labelCol;
    private final String valueCol;

    public SpinnerValue(Map item, String labelCol, String valueCol) {
        this.item = item;
        this.labelCol = labelCol;
        this.valueCol = valueCol;
    }

    @Override
    public String toString() {
        return getLabel();
    }

    @Override
    public String getValue() {
        return (String) item.get(valueCol);
    }

    @Override
    public String getLabel() {
        return (String) item.get(labelCol);
    }

    @Override
    public Map getItem() {
        return item;
    }

    /**
     * Take list of maps and prepares them for use as values on a spinner.
     *
     * @param data
     *
     * @return
     */
    public static List<SpinnerValueInterface> fromCollection(List<Map> data, String colKey,
                                                             String valueKey) {
        List<SpinnerValueInterface> choices = new ArrayList<>();
        Map empty = new HashMap();
        empty.put("name", "");
        empty.put("value", "");
        choices.add(new SpinnerValue(empty, "name", "value"));
        for (Map it : data) {
            choices.add(new SpinnerValue(it, colKey, valueKey));
        }
        return choices;
    }
}

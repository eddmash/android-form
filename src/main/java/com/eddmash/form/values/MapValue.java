package com.eddmash.form.values;
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

/**
 * {@link ValueInterface}
 * <p>
 * Use this if you need to be able to access the map that the value and label where pulled from
 * latter.
 */
public class MapValue implements ValueInterface<Map> {
    private Map item;
    private final String labelCol;
    private final String valueCol;

    public MapValue(Map item, String labelCol, String valueCol) {
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
     * @return
     */
    public static List<ValueInterface> fromCollection(List<Map> data, String colKey,
                                                      String valueKey) {
        List<ValueInterface> choices = new ArrayList<>();
        Map empty = new HashMap();
        empty.put("name", "");
        empty.put("value", "");
        choices.add(new MapValue(empty, "name", "value"));
        for (Map it : data) {
            choices.add(new MapValue(it, colKey, valueKey));
        }
        return choices;
    }
}

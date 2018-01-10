package com.eddmash.form.fields;
/*
* This file is part of the Tools package.
* 
* (c) Eddilbert Macharia (http://eddmash.com)<edd.cowan@gmail.com>
*
* For the full copyright and license information, please view the LICENSE
* file that was distributed with this source code.
*/

import android.view.View;

import java.util.Map;

/**
 * Field that manipulates multiple views together.
 */
interface CollectionFieldInterface extends FieldInterface {

    /**
     * The fields that make up the collection
     *
     * @return map of fields. that are the in the collection field.
     */
    Map<String, FieldInterface> getFields();

    /**
     * Add view to the collection.
     *
     * @param name identify the view uniquely
     * @param view the view instance
     */
    void addField(String name, View view);

    /**
     * Add view to the collection.
     *
     * @param name     identify the view uniquely
     * @param view     the view instance
     * @param editable indicate if view allows having its values being set,
     *                 true if view is editable, else false.
     */
    void addField(String name, View view, boolean editable);

    /**
     * Add field to the collection.
     *
     * @param field field to be added to the collection
     */
    void addField(FieldInterface field);

}

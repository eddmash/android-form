package com.eddmash.form.fields;
/*
* This file is part of the androidcomponents package.
* 
* (c) Eddilbert Macharia (http://eddmash.com)<edd.cowan@gmail.com>
*
* For the full copyright and license information, please view the LICENSE
* file that was distributed with this source code.
*/

import android.view.View;

import com.eddmash.form.FormException;

import java.util.List;

public interface MultiFieldInterface {

    FieldInterface getField(String id) throws FormException;

    void addView(String id, View view);

    List<FieldInterface> getFields();

    void removeView(String id);

    /**
     * Get the number of views the multifield contains.
     *
     * @return
     */
    int getChildCount();
}

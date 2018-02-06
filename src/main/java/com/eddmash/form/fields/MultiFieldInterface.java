package com.eddmash.form.fields;
/*
* This file is part of the mfivms_malawi_registration_and package.
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

    FieldInterface getField(View view) throws FormException;

    List<View> getViews();

    void addView(View view);

    void removeView(View view);
}

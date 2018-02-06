package com.eddmash.form;
/*
* This file is part of the mfivms_malawi_registration_and package.
* 
* (c) Eddilbert Macharia (http://eddmash.com)<edd.cowan@gmail.com>
*
* For the full copyright and license information, please view the LICENSE
* file that was distributed with this source code.
*/

import com.eddmash.form.FormInterface;

/**
 * This makes the a form able to deal with a form as a whole
 */
public interface FormAwareInterface {
    void setForm(FormInterface form);
}

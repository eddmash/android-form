package com.eddmash.form.collection;
/*
* This file is part of the Tools package.
* 
* (c) Eddilbert Macharia (http://eddmash.com)<edd.cowan@gmail.com>
*
* For the full copyright and license information, please view the LICENSE
* file that was distributed with this source code.
*/

import com.eddmash.form.FormInterface;

/**
 * Form that need to
 */
public interface InnerFormInterface extends FormInterface {

    String getIdentifier();

    String[] requires();

    FormCollectionInterface getParent();
}

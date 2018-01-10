package com.eddmash.form;
/*
* This file is part of the Tools package.
* 
* (c) Eddilbert Macharia (http://eddmash.com)<edd.cowan@gmail.com>
*
* For the full copyright and license information, please view the LICENSE
* file that was distributed with this source code.
*/

public interface SpinnerValueInterface<T> {
    String getValue();
    String getLabel();
    T getItem() ;
}

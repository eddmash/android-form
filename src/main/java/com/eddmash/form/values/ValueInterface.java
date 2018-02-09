package com.eddmash.form.values;
/*
* This file is part of the Tools package.
* 
* (c) Eddilbert Macharia (http://eddmash.com)<edd.cowan@gmail.com>
*
* For the full copyright and license information, please view the LICENSE
* file that was distributed with this source code.
*/

/**
 * This class make it easy to deal with data passed into views like spinner.
 * <p>
 * e.g. if you have a user records [{"gender":"male", "id":"1"},{"gender":"Female", "id":"2"}] and
 * you would like to display the 'gender' on the spinner and whilst making it easy to get the id
 * assigned to the gender when its selected.
 * <p>
 * <pre>
 *
 *  List genders = new ArrayList<>();
 *  genders.add(new SimpleValue(" ", " "));
 *  genders.add(new SimpleValue("1", "Male"));
 *  genders.add(new SimpleValue("2", "Female"));
 *
 *  Spinner genderSpinner = findViewById(R.id.gender);
 *
 *  ArrayAdapter<SimpleValue> adapter = new ArrayAdapter<>(this,
 *                                          android.R.layout.simple_list_item_1, genders);
 *  genderSpinner.setAdapter(adapter);
 *
 * </pre>
 * <p>
 * With this setup you can retrieve the id of the selected gender as follows
 * <p>
 * <pre>
 *
 *     genderSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
 *          {@literal @}Override
 *          public void onItemClick(AdapterView<?> adapterView, View view, int i,  long l)
 *          {
 *                  if (adapterView.getSelectedItem() instanceof ValueInterface) {
 *                  ValueInterface val = (ValueInterface) adapterView.getSelectedItem();
 *                  val.getItem(); // get the data structure backing this value item
 *                  val.getLabel(); // the the label
 *                  val.getValue(); // get the actual value
 *              }
 *          }
 *    });
 * </pre>
 *
 * @param <T>
 */
public interface ValueInterface<T> {

    /**
     * The actual value that we need regardless of what is displayed to the user.
     *
     * @return
     */
    String getValue();

    /**
     * This is displayed to the use, e.g. in the examples above Male and Female will be displated.
     *
     * @return
     */
    String getLabel();

    /**
     * This should return the actual datastructure backing the ValueInterface instance.
     * {@link MapValue#getItem()} } which returns a map from which the value and label were
     * retrieved.
     *
     * @return
     */
    T getItem();
}

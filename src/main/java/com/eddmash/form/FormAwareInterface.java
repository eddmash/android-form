package com.eddmash.form;
/*
* This file is part of the mfivms_malawi_registration_and package.
* 
* (c) Eddilbert Macharia (http://eddmash.com)<edd.cowan@gmail.com>
*
* For the full copyright and license information, please view the LICENSE
* file that was distributed with this source code.
*/

import android.widget.EditText;
import android.widget.TextView;

import com.eddmash.validation.checks.CheckSingle;

import java.util.Map;

/**
 * Any class the implements this interface gets the form passed to it via the
 * {@link #setForm(FormInterface)}.
 * <p>
 * This class come in handy when creating validation checks that need to be away of the form,
 * especially when performing form wide validations like on the {@link FormInterface#validate()}
 * method.
 * <p>
 * A good examples is the {@link com.eddmash.form.fields.FieldInterface Field } which implements
 * this
 * interface.
 * <p>
 * The following examples how this interface can be used to create form wide check.
 * <p>
 * <p>
 * <pre>
 * public class BasicForm extends Form {
 *
 *      {@literal @}Override
 *      public void validate() {
 *          try {
 *              addCheck(new PasswordCheck(password1Edittext, password2Edittext,
 *              "Password should match"));
 *          } catch (FormException e) {
 *              e.printStackTrace();
 *          }
 *      }
 *
 *      {@literal @}Override
 *      public void save() throws FormException {
 *
 *      }
 *
 * }
 * </pre>
 * <p>
 * A sample check that uses the FormAwareInterface interface
 * <p>
 * <p>
 * <pre>
 * class PasswordCheck extends CheckSingle implements FormAwareInterface {
 *      private final EditText view;
 *      private final String errorMsg;
 *      private FormInterface form;
 *
 *      public PasswordCheck(EditText view, String errorMsg) {
 *          this.view = view;
 *          this.errorMsg = errorMsg;
 *      }
 *
 *      {@literal @}Override
 *      public boolean run() {
 *          try {
 *              Map val = form.getValues();
 *              Object pass1 = val.get("password_1");
 *              Object pass2 = val.get("password_2");
 *              if (pass1.equals(pass2)) {
 *                  return true;
 *              }
 *          } catch (FormException e) {
 *              e.printStackTrace();
 *          }
 *          return false;
 *      }
 *
 *      {@literal @}Override
 *      public String getErrorMsg() {
 *          return errorMsg;
 *      }
 *      {@literal @}Override
 *      protected TextView getView() {
 *          return view;
 *      }
 *      {@literal @}Override
 *      public void setForm(FormInterface form) {
 *          this.form = form;
 *      }
 *  }
 * </pre>
 */
public interface FormAwareInterface {

    /**
     * The form that will hold this class is passed in.
     *
     * @param form
     */
    void setForm(FormInterface form);
}

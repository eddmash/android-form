.. java:import:: android.widget EditText

.. java:import:: android.widget TextView

.. java:import:: com.eddmash.validation.checks CheckSingle

.. java:import:: java.util Map

FormAwareInterface
==================

.. java:package:: com.eddmash.form
   :noindex:

.. java:type:: public interface FormAwareInterface

   Any class the implements this interface gets the form passed to it via the \ :java:ref:`setForm(FormInterface)`\ .

   This class come in handy when creating validation checks that need to be away of the form, especially when performing form wide validations like on the \ :java:ref:`FormInterface.validate()`\  method.

   A good examples is the \ :java:ref:`Field <com.eddmash.form.fields.FieldInterface>`\  which implements this interface.

   The following examples how this interface can be used to create form wide check.

   .. parsed-literal::

      public class BasicForm extends Form {

           @Override
           public void validate() {
               try {
                   addCheck(new PasswordCheck(password1Edittext, password2Edittext,
                   "Password should match"));
               } catch (FormException e) {
                   e.printStackTrace();
               }
           }

           @Override
           public void save() throws FormException {

           }

      }

   A sample check that uses the FormAwareInterface interface

   .. parsed-literal::

      class PasswordCheck extends CheckSingle implements FormAwareInterface {
           private final EditText view;
           private final String errorMsg;
           private FormInterface form;

           public PasswordCheck(EditText view, String errorMsg) {
               this.view = view;
               this.errorMsg = errorMsg;
           }

           @Override
           public boolean run() {
               try {
                   Map val = form.getValues();
                   Object pass1 = val.get("password_1");
                   Object pass2 = val.get("password_2");
                   if (pass1.equals(pass2)) {
                       return true;
                   }
               } catch (FormException e) {
                   e.printStackTrace();
               }
               return false;
           }

           @Override
           public String getErrorMsg() {
               return errorMsg;
           }
           @Override
           protected TextView getView() {
               return view;
           }
           @Override
           public void setForm(FormInterface form) {
               this.form = form;
           }
       }

Methods
-------
setForm
^^^^^^^

.. java:method::  void setForm(FormInterface form)
   :outertype: FormAwareInterface

   The form that will hold this class is passed in.

   :param form:


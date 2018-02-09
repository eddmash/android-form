.. java:import:: android.editText View

.. java:import:: com.eddmash.form.fields FieldInterface

.. java:import:: com.eddmash.validation ValidatorInterface

.. java:import:: com.eddmash.validation.checks CheckInterface

.. java:import:: java.util List

.. java:import:: java.util Map

FormInterface
=============

.. java:package:: com.eddmash.form
   :noindex:

.. java:type:: public interface FormInterface

Methods
-------
addCheck
^^^^^^^^

.. java:method::  void addCheck(CheckInterface check)
   :outertype: FormInterface

   Add a validation check.

   :param check:

addField
^^^^^^^^

.. java:method::  void addField(FieldInterface field)
   :outertype: FormInterface

addField
^^^^^^^^

.. java:method::  void addField(String colName, View editText)
   :outertype: FormInterface

disableCheck
^^^^^^^^^^^^

.. java:method::  void disableCheck(CheckInterface check)
   :outertype: FormInterface

   Disable a validation check

   :param check:

getErrors
^^^^^^^^^

.. java:method::  Map<String, List> getErrors()
   :outertype: FormInterface

   Returns all the errors on the form after validation.

   :return: the key is the form identifier and the values is a list of all the validation errors related with the form.

getField
^^^^^^^^

.. java:method::  FieldInterface getField(String fieldName) throws FormException
   :outertype: FormInterface

getFields
^^^^^^^^^

.. java:method::  Map<String, FieldInterface> getFields()
   :outertype: FormInterface

getIdentifier
^^^^^^^^^^^^^

.. java:method::  String getIdentifier()
   :outertype: FormInterface

   A unique identifier for this form.

getValidator
^^^^^^^^^^^^

.. java:method::  ValidatorInterface getValidator()
   :outertype: FormInterface

   The validator this form will be using to validate the inner forms.

getValue
^^^^^^^^

.. java:method::  Object getValue(String fieldName) throws FormException
   :outertype: FormInterface

   Returns the value a particular field.

   The returned values depends on the \ :java:ref:`field <FieldInterface>`\  some fields the values is a string whilst others its a list of string.

   Consult the specific \ :java:ref:`field <FieldInterface>`\  to get the returned value.

   :param fieldName:
   :throws FormException:

getValues
^^^^^^^^^

.. java:method::  Map<String, Object> getValues() throws FormException
   :outertype: FormInterface

   Return the values of each field on the form.

   The returned values depends on the \ :java:ref:`field <FieldInterface>`\  some fields the values is a string whilst others its a list of string.

   Consult the specific \ :java:ref:`field <FieldInterface>`\  to get the returned value.

   :throws FormException:
   :return: a map, where keys a field identifier used when adding field to form and values are the fields respective values.

isValid
^^^^^^^

.. java:method::  boolean isValid()
   :outertype: FormInterface

   This is the entry point for form validations.

   It firsts invokes the \ :java:ref:`validate()`\  to get the form wide validation .

   It the tells the validator to run the validation check.

   :return: true only if the validation checks passed.

removeField
^^^^^^^^^^^

.. java:method::  void removeField(String replace)
   :outertype: FormInterface

removeField
^^^^^^^^^^^

.. java:method::  void removeField(FieldInterface field)
   :outertype: FormInterface

save
^^^^

.. java:method::  void save() throws FormException
   :outertype: FormInterface

   This is where you should put you saving logic.

   throw FormException if validation fails.

   :throws FormException:

setData
^^^^^^^

.. java:method::  void setData(Map data) throws FormException
   :outertype: FormInterface

setValue
^^^^^^^^

.. java:method::  void setValue(String fieldName, Object value)
   :outertype: FormInterface

   Set value for a specific.

   :param fieldName: the identifier to use to locate the field being set.
   :param value: the value being set, this depends on specific \ :java:ref:`field <FieldInterface>`\  .consult specific \ :java:ref:`field <FieldInterface>`\  to find expected value.

validate
^^^^^^^^

.. java:method::  void validate()
   :outertype: FormInterface

   This is the right place to perform form wide validations. That is validating fields against each other, also validate against parent form fields.

   At this point you have access to the getValues() of both parent form and current form you can use this values to compare against.

   The recommend approach is to a create check that implements FormAwareInterface and add it to the validator.

   This method is invoked before the field specific validations have been run.


.. java:import:: android.util Log

.. java:import:: android.view View

.. java:import:: com.eddmash.form.fields CollectionField

.. java:import:: com.eddmash.form.fields FieldInterface

.. java:import:: com.eddmash.form.fields ViewField

.. java:import:: com.eddmash.validation Validator

.. java:import:: com.eddmash.validation ValidatorInterface

.. java:import:: com.eddmash.validation.checks CheckInterface

.. java:import:: java.util ArrayList

.. java:import:: java.util HashMap

.. java:import:: java.util List

.. java:import:: java.util Map

Form
====

.. java:package:: com.eddmash.form
   :noindex:

.. java:type:: public abstract class Form implements FormInterface

Constructors
------------
Form
^^^^

.. java:constructor:: public Form()
   :outertype: Form

Form
^^^^

.. java:constructor:: public Form(ValidatorInterface validator)
   :outertype: Form

Methods
-------
addCheck
^^^^^^^^

.. java:method:: @Override public void addCheck(CheckInterface check)
   :outertype: Form

addField
^^^^^^^^

.. java:method:: @Override public void addField(String colName, View view)
   :outertype: Form

addField
^^^^^^^^

.. java:method:: @Override public void addField(FieldInterface field)
   :outertype: Form

disableCheck
^^^^^^^^^^^^

.. java:method:: @Override public void disableCheck(CheckInterface check)
   :outertype: Form

getErrors
^^^^^^^^^

.. java:method:: @Override public Map<String, List> getErrors()
   :outertype: Form

getField
^^^^^^^^

.. java:method:: @Override public FieldInterface getField(String fieldName) throws FormException
   :outertype: Form

getFields
^^^^^^^^^

.. java:method:: @Override public Map<String, FieldInterface> getFields()
   :outertype: Form

getIdentifier
^^^^^^^^^^^^^

.. java:method:: @Override public String getIdentifier()
   :outertype: Form

getValidator
^^^^^^^^^^^^

.. java:method:: @Override public ValidatorInterface getValidator()
   :outertype: Form

getValue
^^^^^^^^

.. java:method:: @Override public Object getValue(String fieldName) throws FormException
   :outertype: Form

getValues
^^^^^^^^^

.. java:method:: public Map<String, Object> getValues() throws FormException
   :outertype: Form

isValid
^^^^^^^

.. java:method:: @Override public boolean isValid()
   :outertype: Form

removeField
^^^^^^^^^^^

.. java:method:: @Override public void removeField(String colName)
   :outertype: Form

removeField
^^^^^^^^^^^

.. java:method:: @Override public void removeField(FieldInterface field)
   :outertype: Form

setData
^^^^^^^

.. java:method:: @Override public void setData(Map data) throws FormException
   :outertype: Form

setValue
^^^^^^^^

.. java:method:: @Override public void setValue(String fieldName, Object value)
   :outertype: Form

validate
^^^^^^^^

.. java:method:: @Override public void validate()
   :outertype: Form


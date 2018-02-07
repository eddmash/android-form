.. java:import:: android.util Log

.. java:import:: com.eddmash.form FormException

.. java:import:: com.eddmash.validation Validator

.. java:import:: com.eddmash.validation ValidatorInterface

.. java:import:: org.json JSONArray

.. java:import:: java.util ArrayList

.. java:import:: java.util Arrays

.. java:import:: java.util HashMap

.. java:import:: java.util List

.. java:import:: java.util Map

FormCollection
==============

.. java:package:: com.eddmash.form.collection
   :noindex:

.. java:type:: public class FormCollection implements FormCollectionInterface

   Use this class when you want to deal on multiple forms all at once.

Constructors
------------
FormCollection
^^^^^^^^^^^^^^

.. java:constructor:: public FormCollection()
   :outertype: FormCollection

FormCollection
^^^^^^^^^^^^^^

.. java:constructor:: public FormCollection(ValidatorInterface validator)
   :outertype: FormCollection

Methods
-------
addForm
^^^^^^^

.. java:method:: @Override public void addForm(InnerFormInterface form) throws FormException
   :outertype: FormCollection

getForm
^^^^^^^

.. java:method:: @Override public InnerFormInterface getForm(String identifier) throws FormException
   :outertype: FormCollection

getValidator
^^^^^^^^^^^^

.. java:method:: @Override public ValidatorInterface getValidator()
   :outertype: FormCollection

isValid
^^^^^^^

.. java:method:: @Override public boolean isValid()
   :outertype: FormCollection

removeForm
^^^^^^^^^^

.. java:method:: @Override public void removeForm(InnerFormInterface form)
   :outertype: FormCollection

save
^^^^

.. java:method:: @Override public boolean save() throws FormException
   :outertype: FormCollection


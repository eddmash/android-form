.. java:import:: com.eddmash.form FormException

.. java:import:: com.eddmash.validation ValidatorInterface

FormCollectionInterface
=======================

.. java:package:: com.eddmash.form.collection
   :noindex:

.. java:type:: public interface FormCollectionInterface

   Use this class when you want to deal on multiple forms all at once.

Methods
-------
addForm
^^^^^^^

.. java:method::  void addForm(InnerFormInterface form) throws FormException
   :outertype: FormCollectionInterface

   Add a form into the collection.

   :param form:
   :throws FormException:

getForm
^^^^^^^

.. java:method::  InnerFormInterface getForm(String identifier) throws FormException
   :outertype: FormCollectionInterface

   Get a form in the collection by its identifier.

   :param identifier:
   :throws FormException:

getValidator
^^^^^^^^^^^^

.. java:method::  ValidatorInterface getValidator()
   :outertype: FormCollectionInterface

   The validator this collection will be using to validate the inner forms.

   This is basically a parent validator which calls the individual validators bound to each of the inner forms.

isValid
^^^^^^^

.. java:method::  boolean isValid()
   :outertype: FormCollectionInterface

   Entry point for validation of all the innerforms on this collection.

   Runs validation for each of the inner forms.

removeForm
^^^^^^^^^^

.. java:method::  void removeForm(InnerFormInterface form)
   :outertype: FormCollectionInterface

   REmove a from the collection.

   :param form:

save
^^^^

.. java:method::  boolean save() throws FormException
   :outertype: FormCollectionInterface

   The entry point of form saving.

   This method calls the save() of each innerform attached to this collection

   Wrap this method in a transaction to ensure if any of the inner form fails to save, All the other innerforms arent saved. for consistency sake.

   :throws FormException:


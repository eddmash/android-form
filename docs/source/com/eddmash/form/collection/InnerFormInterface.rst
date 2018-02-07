.. java:import:: com.eddmash.form FormInterface

InnerFormInterface
==================

.. java:package:: com.eddmash.form.collection
   :noindex:

.. java:type:: public interface InnerFormInterface extends FormInterface

   This is basically \ :java:ref:`form <FormInterface>`\ that has the capability of being used with a form collection.

   This form also has the added capability of depending on another form thats in the same collection as the one it belongs to.

Methods
-------
getParent
^^^^^^^^^

.. java:method::  FormCollectionInterface getParent()
   :outertype: InnerFormInterface

   The collection form in which this form belongs to.

requires
^^^^^^^^

.. java:method::  String[] requires()
   :outertype: InnerFormInterface

   An string array of other inner forms that this form should depend on i.e. those forms should be validated before this during the validation stage and should be saved before this is saved.


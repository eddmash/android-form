.. java:import:: com.eddmash.form Form

.. java:import:: com.eddmash.form FormInterface

.. java:import:: com.eddmash.validation ValidatorInterface

InnerForm
=========

.. java:package:: com.eddmash.form.collection
   :noindex:

.. java:type:: public abstract class InnerForm extends Form implements InnerFormInterface

   This is basically \ :java:ref:`form <FormInterface>`\ that has the capability of being used with a form collection.

Fields
------
form
^^^^

.. java:field:: protected FormCollectionInterface form
   :outertype: InnerForm

Constructors
------------
InnerForm
^^^^^^^^^

.. java:constructor:: public InnerForm()
   :outertype: InnerForm

InnerForm
^^^^^^^^^

.. java:constructor:: public InnerForm(ValidatorInterface validator)
   :outertype: InnerForm

Methods
-------
getParent
^^^^^^^^^

.. java:method:: @Override public FormCollectionInterface getParent()
   :outertype: InnerForm

setParent
^^^^^^^^^

.. java:method:: public void setParent(FormCollectionInterface form)
   :outertype: InnerForm


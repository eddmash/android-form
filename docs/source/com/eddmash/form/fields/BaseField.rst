.. java:import:: com.eddmash.form FormException

.. java:import:: com.eddmash.form FormInterface

BaseField
=========

.. java:package:: com.eddmash.form.fields
   :noindex:

.. java:type:: public abstract class BaseField<V, E> implements FieldInterface<V, E>

Fields
------
form
^^^^

.. java:field:: protected FormInterface form
   :outertype: BaseField

isEditable
^^^^^^^^^^

.. java:field:: protected boolean isEditable
   :outertype: BaseField

Constructors
------------
BaseField
^^^^^^^^^

.. java:constructor::  BaseField(boolean isEditable)
   :outertype: BaseField

Methods
-------
getForm
^^^^^^^

.. java:method:: @Override public FormInterface getForm()
   :outertype: BaseField

getValue
^^^^^^^^

.. java:method:: @Override public abstract E getValue() throws FormException
   :outertype: BaseField

getView
^^^^^^^

.. java:method:: @Override public abstract V getView() throws FormException
   :outertype: BaseField

isEditable
^^^^^^^^^^

.. java:method:: @Override public boolean isEditable()
   :outertype: BaseField

setForm
^^^^^^^

.. java:method:: @Override public FieldInterface setForm(FormInterface form)
   :outertype: BaseField

setValue
^^^^^^^^

.. java:method:: @Override public abstract void setValue(E o) throws FormException
   :outertype: BaseField


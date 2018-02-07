.. java:import:: com.eddmash.form FormException

SimpleField
===========

.. java:package:: com.eddmash.form.fields
   :noindex:

.. java:type:: public class SimpleField extends BaseField<Object, Object>

Constructors
------------
SimpleField
^^^^^^^^^^^

.. java:constructor:: public SimpleField(String name, Object value)
   :outertype: SimpleField

SimpleField
^^^^^^^^^^^

.. java:constructor:: public SimpleField(String name, Object value, boolean isEditable)
   :outertype: SimpleField

Methods
-------
getName
^^^^^^^

.. java:method:: @Override public String getName()
   :outertype: SimpleField

getValue
^^^^^^^^

.. java:method:: @Override public Object getValue() throws FormException
   :outertype: SimpleField

getView
^^^^^^^

.. java:method:: @Override public Object getView() throws FormException
   :outertype: SimpleField

setValue
^^^^^^^^

.. java:method:: @Override public void setValue(Object o) throws FormException
   :outertype: SimpleField


.. java:import:: android.view View

.. java:import:: com.eddmash.form FormException

.. java:import:: java.util ArrayList

.. java:import:: java.util HashMap

.. java:import:: java.util List

.. java:import:: java.util Map

MultiField
==========

.. java:package:: com.eddmash.form.fields
   :noindex:

.. java:type:: public class MultiField extends BaseField<List<View>, Map> implements MultiFieldInterface

   This fields deals with multi fields but they are each treated as one.

   This mean the values return are for those fields that have values, the setting also happens to those fields who data is provided.

Constructors
------------
MultiField
^^^^^^^^^^

.. java:constructor:: public MultiField(String name, boolean isEditable)
   :outertype: MultiField

MultiField
^^^^^^^^^^

.. java:constructor:: public MultiField(String name)
   :outertype: MultiField

Methods
-------
addView
^^^^^^^

.. java:method:: @Override public void addView(String id, View view)
   :outertype: MultiField

getChildCount
^^^^^^^^^^^^^

.. java:method:: @Override public int getChildCount()
   :outertype: MultiField

getField
^^^^^^^^

.. java:method:: @Override public FieldInterface getField(String id) throws FormException
   :outertype: MultiField

getFields
^^^^^^^^^

.. java:method:: @Override public List<FieldInterface> getFields()
   :outertype: MultiField

getName
^^^^^^^

.. java:method:: @Override public String getName()
   :outertype: MultiField

getValue
^^^^^^^^

.. java:method:: @Override public Map getValue() throws FormException
   :outertype: MultiField

getView
^^^^^^^

.. java:method:: @Override public List<View> getView() throws FormException
   :outertype: MultiField

removeView
^^^^^^^^^^

.. java:method:: @Override public void removeView(String id)
   :outertype: MultiField

setValue
^^^^^^^^

.. java:method:: @Override public void setValue(Map o) throws FormException
   :outertype: MultiField


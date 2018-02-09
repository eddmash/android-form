.. java:import:: android.editText View

.. java:import:: com.eddmash.form FormException

.. java:import:: java.util ArrayList

.. java:import:: java.util HashMap

.. java:import:: java.util LinkedHashMap

.. java:import:: java.util List

.. java:import:: java.util Map

CollectionField
===============

.. java:package:: com.eddmash.form.fields
   :noindex:

.. java:type:: public class CollectionField extends BaseField<List<View>, Object> implements CollectionFieldInterface<List<View>, Object>

   Field that manipulates multiple individual views together.

   Its important to note that the specific fields don't loose there individuality and the values return will be values for each single editText.

   Setting will be attempted on each single editText if its value is found in the map of values passed in.

Constructors
------------
CollectionField
^^^^^^^^^^^^^^^

.. java:constructor:: public CollectionField(String tag)
   :outertype: CollectionField

CollectionField
^^^^^^^^^^^^^^^

.. java:constructor:: public CollectionField(String name, boolean isEditable)
   :outertype: CollectionField

Methods
-------
addField
^^^^^^^^

.. java:method:: @Override public void addField(String name, View editText)
   :outertype: CollectionField

addField
^^^^^^^^

.. java:method:: @Override public void addField(FieldInterface field)
   :outertype: CollectionField

addField
^^^^^^^^

.. java:method:: @Override public void addField(String name, View editText, boolean editable)
   :outertype: CollectionField

getFields
^^^^^^^^^

.. java:method:: @Override public Map<String, FieldInterface> getFields()
   :outertype: CollectionField

getName
^^^^^^^

.. java:method:: @Override public String getName()
   :outertype: CollectionField

getValue
^^^^^^^^

.. java:method:: @Override public Map<String, Object> getValue() throws FormException
   :outertype: CollectionField

getView
^^^^^^^

.. java:method:: @Override public List<View> getView() throws FormException
   :outertype: CollectionField

setValue
^^^^^^^^

.. java:method:: @Override public void setValue(Object o) throws FormException
   :outertype: CollectionField


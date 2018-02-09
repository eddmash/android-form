.. java:import:: android.editText View

.. java:import:: com.eddmash.form FormException

.. java:import:: java.util List

.. java:import:: java.util Map

CollectionFieldInterface
========================

.. java:package:: com.eddmash.form.fields
   :noindex:

.. java:type:: public interface CollectionFieldInterface<T, E> extends FieldInterface<T, E>

   Field that manipulates multiple views together.

   Its important to note that the specific fields don't loose there individuality and the values return will be values for each single editText.

   Setting will be attempted on each single editText if its value is found in the map of values passed in.

Methods
-------
addField
^^^^^^^^

.. java:method::  void addField(String name, View editText)
   :outertype: CollectionFieldInterface

   Add editText to the collection.

   :param name: identify the editText uniquely
   :param editText: the editText instance

addField
^^^^^^^^

.. java:method::  void addField(String name, View editText, boolean editable)
   :outertype: CollectionFieldInterface

   Add editText to the collection.

   :param name: identify the editText uniquely
   :param editText: the editText instance
   :param editable: indicate if editText allows having its values being set, true if editText is editable, else false.

addField
^^^^^^^^

.. java:method::  void addField(FieldInterface field)
   :outertype: CollectionFieldInterface

   Add field to the collection.

   :param field: field to be added to the collection

getFields
^^^^^^^^^

.. java:method::  Map<String, FieldInterface> getFields()
   :outertype: CollectionFieldInterface

   The fields that make up the collection

   :return: map of fields. that are the in the collection field.

getValue
^^^^^^^^

.. java:method:: @Override  E getValue() throws FormException
   :outertype: CollectionFieldInterface

getView
^^^^^^^

.. java:method:: @Override  T getView() throws FormException
   :outertype: CollectionFieldInterface

setValue
^^^^^^^^

.. java:method:: @Override  void setValue(E o) throws FormException
   :outertype: CollectionFieldInterface


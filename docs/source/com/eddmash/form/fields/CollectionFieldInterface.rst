.. java:import:: android.view View

.. java:import:: com.eddmash.form FormException

.. java:import:: java.util List

.. java:import:: java.util Map

CollectionFieldInterface
========================

.. java:package:: com.eddmash.form.fields
   :noindex:

.. java:type:: public interface CollectionFieldInterface<T, E> extends FieldInterface<T, E>

   Field that manipulates multiple views together.

   Its important to note that the specific fields don't loose there individuality and the values return will be values for each single view.

   Setting will be attempted on each single view if its value is found in the map of values passed in.

Methods
-------
addField
^^^^^^^^

.. java:method::  void addField(String name, View view)
   :outertype: CollectionFieldInterface

   Add view to the collection.

   :param name: identify the view uniquely
   :param view: the view instance

addField
^^^^^^^^

.. java:method::  void addField(String name, View view, boolean editable)
   :outertype: CollectionFieldInterface

   Add view to the collection.

   :param name: identify the view uniquely
   :param view: the view instance
   :param editable: indicate if view allows having its values being set, true if view is editable, else false.

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


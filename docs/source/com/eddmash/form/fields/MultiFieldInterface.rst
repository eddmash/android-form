.. java:import:: android.view View

.. java:import:: com.eddmash.form FormException

.. java:import:: java.util List

MultiFieldInterface
===================

.. java:package:: com.eddmash.form.fields
   :noindex:

.. java:type:: public interface MultiFieldInterface

Methods
-------
addView
^^^^^^^

.. java:method::  void addView(String id, View view)
   :outertype: MultiFieldInterface

getChildCount
^^^^^^^^^^^^^

.. java:method::  int getChildCount()
   :outertype: MultiFieldInterface

   Get the number of views the multifield contains.

getField
^^^^^^^^

.. java:method::  FieldInterface getField(String id) throws FormException
   :outertype: MultiFieldInterface

getFields
^^^^^^^^^

.. java:method::  List<FieldInterface> getFields()
   :outertype: MultiFieldInterface

removeView
^^^^^^^^^^

.. java:method::  void removeView(String id)
   :outertype: MultiFieldInterface


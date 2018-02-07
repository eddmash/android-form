.. java:import:: java.util ArrayList

.. java:import:: java.util HashMap

.. java:import:: java.util List

.. java:import:: java.util Map

ViewValue
=========

.. java:package:: com.eddmash.form.values
   :noindex:

.. java:type:: public class ViewValue implements ValueInterface<Map>

Constructors
------------
ViewValue
^^^^^^^^^

.. java:constructor:: public ViewValue(Map item, String labelCol, String valueCol)
   :outertype: ViewValue

Methods
-------
fromCollection
^^^^^^^^^^^^^^

.. java:method:: public static List<ValueInterface> fromCollection(List<Map> data, String colKey, String valueKey)
   :outertype: ViewValue

   Take list of maps and prepares them for use as values on a spinner.

   :param data:

getItem
^^^^^^^

.. java:method:: @Override public Map getItem()
   :outertype: ViewValue

getLabel
^^^^^^^^

.. java:method:: @Override public String getLabel()
   :outertype: ViewValue

getValue
^^^^^^^^

.. java:method:: @Override public String getValue()
   :outertype: ViewValue

toString
^^^^^^^^

.. java:method:: @Override public String toString()
   :outertype: ViewValue


.. java:import:: android.view View

.. java:import:: android.widget CompoundButton

.. java:import:: android.widget EditText

.. java:import:: android.widget Spinner

.. java:import:: android.widget TextView

.. java:import:: com.eddmash.form FormException

.. java:import:: com.eddmash.form.values ValueInterface

.. java:import:: com.eddmash.form.values ViewValue

.. java:import:: com.eddmash.views CollectionView

ViewField
=========

.. java:package:: com.eddmash.form.fields
   :noindex:

.. java:type:: public class ViewField extends BaseField<View, String>

Constructors
------------
ViewField
^^^^^^^^^

.. java:constructor:: public ViewField(String name, View view)
   :outertype: ViewField

ViewField
^^^^^^^^^

.. java:constructor:: public ViewField(String name, View view, boolean isEditable)
   :outertype: ViewField

Methods
-------
getName
^^^^^^^

.. java:method:: @Override public String getName()
   :outertype: ViewField

getSpinnerValuePosition
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public int getSpinnerValuePosition(Spinner spinner, Object val)
   :outertype: ViewField

getValue
^^^^^^^^

.. java:method:: @Override public String getValue() throws FormException
   :outertype: ViewField

getView
^^^^^^^

.. java:method:: @Override public View getView()
   :outertype: ViewField

setIsEditable
^^^^^^^^^^^^^

.. java:method:: public void setIsEditable(boolean isEditable)
   :outertype: ViewField

setValue
^^^^^^^^

.. java:method:: @Override public void setValue(String val) throws FormException
   :outertype: ViewField


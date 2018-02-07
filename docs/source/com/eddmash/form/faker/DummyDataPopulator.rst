.. java:import:: android.util Log

.. java:import:: android.view View

.. java:import:: android.widget CompoundButton

.. java:import:: android.widget EditText

.. java:import:: android.widget Spinner

.. java:import:: com.eddmash.form FormException

.. java:import:: com.eddmash.form FormInterface

.. java:import:: com.eddmash.form.faker.provider ProviderInterface

.. java:import:: com.eddmash.form.fields CollectionField

.. java:import:: com.eddmash.form.fields MultiField

.. java:import:: com.eddmash.form.fields MultiFieldInterface

.. java:import:: com.eddmash.form.fields SimpleField

.. java:import:: com.eddmash.form.fields ViewField

.. java:import:: com.eddmash.form.fields FieldInterface

.. java:import:: com.eddmash.views CollectionView

.. java:import:: java.util HashMap

.. java:import:: java.util List

.. java:import:: java.util Map

.. java:import:: java.util Random

DummyDataPopulator
==================

.. java:package:: com.eddmash.form.faker
   :noindex:

.. java:type:: public class DummyDataPopulator implements PopulatorInterface

   This is a minimalistic go at data faker.

   This intention is to populate the FormInterface and FieldInterfaces.

Constructors
------------
DummyDataPopulator
^^^^^^^^^^^^^^^^^^

.. java:constructor:: public DummyDataPopulator()
   :outertype: DummyDataPopulator

Methods
-------
populate
^^^^^^^^

.. java:method:: public void populate(FormInterface form) throws FormException
   :outertype: DummyDataPopulator

populate
^^^^^^^^

.. java:method:: public void populate(FieldInterface field) throws FormException
   :outertype: DummyDataPopulator

setFieldProvider
^^^^^^^^^^^^^^^^

.. java:method:: public void setFieldProvider(String name, ProviderInterface provider)
   :outertype: DummyDataPopulator


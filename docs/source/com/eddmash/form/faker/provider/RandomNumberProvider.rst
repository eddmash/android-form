.. java:import:: com.eddmash.form.faker Callback

RandomNumberProvider
====================

.. java:package:: com.eddmash.form.faker.provider
   :noindex:

.. java:type:: public class RandomNumberProvider extends Provider

Fields
------
DECIMAL
^^^^^^^

.. java:field:: public static final String DECIMAL
   :outertype: RandomNumberProvider

INTEGER
^^^^^^^

.. java:field:: public static final String INTEGER
   :outertype: RandomNumberProvider

Constructors
------------
RandomNumberProvider
^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RandomNumberProvider()
   :outertype: RandomNumberProvider

Methods
-------
generate
^^^^^^^^

.. java:method:: @Override public String generate()
   :outertype: RandomNumberProvider

getDecimal
^^^^^^^^^^

.. java:method:: public ProviderInterface getDecimal()
   :outertype: RandomNumberProvider

setMax
^^^^^^

.. java:method:: public RandomNumberProvider setMax(int min)
   :outertype: RandomNumberProvider

setMin
^^^^^^

.. java:method:: public RandomNumberProvider setMin(int max)
   :outertype: RandomNumberProvider


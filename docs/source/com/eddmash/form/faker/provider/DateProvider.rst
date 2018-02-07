.. java:import:: java.text SimpleDateFormat

.. java:import:: java.util Calendar

.. java:import:: java.util Locale

DateProvider
============

.. java:package:: com.eddmash.form.faker.provider
   :noindex:

.. java:type:: public class DateProvider extends Provider

Fields
------
TIME_NOW
^^^^^^^^

.. java:field:: public static final String TIME_NOW
   :outertype: DateProvider

TODAY
^^^^^

.. java:field:: public static final String TODAY
   :outertype: DateProvider

dateFormat
^^^^^^^^^^

.. java:field:: protected String dateFormat
   :outertype: DateProvider

timeFormat
^^^^^^^^^^

.. java:field:: protected String timeFormat
   :outertype: DateProvider

Constructors
------------
DateProvider
^^^^^^^^^^^^

.. java:constructor:: public DateProvider()
   :outertype: DateProvider

Methods
-------
generate
^^^^^^^^

.. java:method:: @Override public String generate()
   :outertype: DateProvider

getDate
^^^^^^^

.. java:method:: public String getDate(String format)
   :outertype: DateProvider

getTime
^^^^^^^

.. java:method:: public ProviderInterface getTime()
   :outertype: DateProvider

setDateFormat
^^^^^^^^^^^^^

.. java:method:: public DateProvider setDateFormat(String dateFormat)
   :outertype: DateProvider

setTimeFormat
^^^^^^^^^^^^^

.. java:method:: public DateProvider setTimeFormat(String timeFormat)
   :outertype: DateProvider

timeNow
^^^^^^^

.. java:method:: public String timeNow()
   :outertype: DateProvider

today
^^^^^

.. java:method:: public String today()
   :outertype: DateProvider


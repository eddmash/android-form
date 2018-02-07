.. java:import:: com.eddmash.form FormException

.. java:import:: com.eddmash.form FormInterface

.. java:import:: com.eddmash.form.faker.provider ProviderInterface

.. java:import:: com.eddmash.form.fields FieldInterface

PopulatorInterface
==================

.. java:package:: com.eddmash.form.faker
   :noindex:

.. java:type:: public interface PopulatorInterface

   Its responsible for populating the \ :java:ref:`FormInterface`\  or \ :java:ref:`FieldInterface`\  provided.

   The populator uses \ :java:ref:`providers <ProviderInterface>`\  to populate each field presented to the populator.

Methods
-------
populate
^^^^^^^^

.. java:method::  void populate(FormInterface form) throws FormException
   :outertype: PopulatorInterface

   Tell the populator to start the population on the specified form.

   :param form:
   :throws FormException:

populate
^^^^^^^^

.. java:method::  void populate(FieldInterface field) throws FormException
   :outertype: PopulatorInterface

   Tell the populator to start the population on the specified field.

   :param field:
   :throws FormException:

setFieldProvider
^^^^^^^^^^^^^^^^

.. java:method::  void setFieldProvider(String name, ProviderInterface provider)
   :outertype: PopulatorInterface

   Set the provider to use the populator a specific field.

   :param name: the name of the field that will use the provider given.
   :param provider: the provider to use instead of the default onces.


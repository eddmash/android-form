.. java:import:: android.view View

.. java:import:: com.eddmash.form FormAwareInterface

.. java:import:: com.eddmash.form FormException

.. java:import:: com.eddmash.form FormInterface

.. java:import:: java.util List

FieldInterface
==============

.. java:package:: com.eddmash.form.fields
   :noindex:

.. java:type:: public interface FieldInterface<T, E> extends FormAwareInterface

   This provides a consitent way of dealing with the different views provided by android.

Methods
-------
getForm
^^^^^^^

.. java:method::  FormInterface getForm()
   :outertype: FieldInterface

   The form instance this field is attached to.

   :return: form

getName
^^^^^^^

.. java:method::  String getName()
   :outertype: FieldInterface

   A name that uniquely identify the view. this is use when you need to pull a specific field from the form instance.

   :return: name

getValue
^^^^^^^^

.. java:method::  E getValue() throws FormException
   :outertype: FieldInterface

   Returns the value of the view

   :throws FormException:
   :return: Object

getView
^^^^^^^

.. java:method::  T getView() throws FormException
   :outertype: FieldInterface

   The actual view object(s) we are operating on.

   Note this may return a list of view objects in case of CollectionField

   :throws FormException: in case it not possible to retrieve the view object
   :return: a view instance

isEditable
^^^^^^^^^^

.. java:method::  boolean isEditable()
   :outertype: FieldInterface

   Is the view editable, this tells the form not to set values for the view and also tells the populator not to populate it.

   :return: true if editable, false otherwise

setValue
^^^^^^^^

.. java:method::  void setValue(E o) throws FormException
   :outertype: FieldInterface

   Set view value.

   :param o:
   :throws FormException:


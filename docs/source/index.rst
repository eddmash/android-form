.. Android Forms documentation master file, created by
   sphinx-quickstart on Wed Feb  7 15:36:05 2018.
   You can adapt this file completely to your liking, but it should at least
   contain the root `toctree` directive.

Welcome to Android Forms documentation!
=========================================

.. toctree::
   :maxdepth: 2
   :caption: Contents:


This library makes it easy to deal with views, especially if dealing with a large amount of views.

It provide a consistent and fluent way of setting, validating, retrieving and saving values from
views.

With this library you not have to change or alter you layout in anyway, but you will be able to
work with multiple forms on multiple fragments via :doc:`FormCollection<form_collection>`.

The library also comes an inbuilt :doc:`Data populator <faker>` to use when developing. This comes
in handy when you want to prepopulate you form with sample data.

For validation the `Validation <http://android-validation-library.readthedocs.io>`_ is used.

install
*******

using Maven.

::

    <dependency>
      <groupId>com.eddmash</groupId>
      <artifactId>android-form</artifactId>
      <version>1.0.7</version>
      <type>pom</type>
    </dependency>

Using gradle

::

    compile 'com.eddmash:android-form:1.0.7'

Usage
*****

To use this library is very easy

.. _basic_form:

- Create :java:ref:`Form <FormInterface>` class


.. code-block:: java

     private class BasicForm extends Form {
            public BasicForm() {
                super();
            }

            public BasicForm(ValidatorInterface validator) {
                super(validator);
            }

            @Override
            public void save() throws FormException {
                // implement the saving logic, you have access to
                // getValues() returns a map of where key is the name of the field and the values
            }
    }

- Create form object

.. code-block:: java

    BasicForm form = new BasicForm();

- Add :java:ref:`Field <FieldInterface>` to :java:ref:`FormInterface <FormInterface>`

.. code-block:: java

    // get the views from the layout
    Spinner genderSpinner = (Spinner) editText.findViewById(R.id.gender);
    EditText fName = (EditText) editText.findViewById(R.id.firstname);
    EditText phone_number = (EditText) editText.findViewById(R.id.phone_number);

    // add views to the form
    form.addField("gender", genderSpinner);
    form.addField("firstname", fName);
    form.addField("phone_number", fName);

    // add validation check
    form.addCheck(new NotEmptyCheck(gender,"Gender cannot be blank"));
    form.addCheck(new NotEmptyCheck(fName,"Firstname cannot be blank"));

- Run :java:ref:`validation <FormInterface.isValid()>` and get the :java:ref:`values <FormInterface.getValues()>`.

.. code-block:: java

    if(form.isValid()){
        form.getValues()// returns a map of where key is the name of the field and the values

    }else{

         LinearLayout errorSpace = (LinearLayout) findViewById(R.id.error_base);
         errorSpace.removeAllViews();// clear space first

         ErrorRenderer errorRenderer = new ErrorRenderer(this, form.getValidator());
         errorRenderer.render(errorSpace);
    }

- :java:ref:`Save <FormInterface.save()>` form :java:ref:`values <FormInterface.getValues()>`

.. code-block:: java

    if(form.isValid()){
        try{
            form.save() // save
        } catch (FormException e) {
            e.printStackTrace();
        }

    }else{

        LinearLayout errorSpace = (LinearLayout) findViewById(R.id.error_base);
        errorSpace.removeAllViews();// clear space first

        ErrorRenderer errorRenderer = new ErrorRenderer(this, form.getValidator());
        errorRenderer.render(errorSpace);
    }


.. toctree::
    :titlesonly:
    :maxdepth: 1

    Introduction <self>
    Collection Form <form_collection>
    Faker <faker>
    Api <packages>
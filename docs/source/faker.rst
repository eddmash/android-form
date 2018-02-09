Data Population
===============

When developing, especially when working with form we need to prepopulate the form with sample
data to ease up our development.

The :java:ref:`faker <PopulatorInterface>` is meant to take care of this for us.

Lets populate our :ref:`basic form <basic_form>` form from earlier with sample data.

.. code-block:: java

    form // the basicform from earlier example

    // create a populator object
    DummyDataPopulator populator = new DummyDataPopulator();

    // format how the data should look
    // this will generate data with the format a mobile number of we use here in kenya
    // +254 722 472 447
    populator.setFieldPopulator("phone_number", new Telephone().setFormat("(+###) ### ### ###"));


    // tell populator to populate the form.
    // it will use the provider we set above for the phone number instead of the default one which
    // would be a random set of numbers
    populator.populate(form);

    // you could also populate single field on its own
    populator.populate(form.getField("gender"));

The kind of data that is generated depends on the type of editText and the name of the field.
e.g. if a editText is edittext of with inputype of number then the populator will generated numbers
for that particular editText.
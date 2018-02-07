Form Collection
===============

This library also supports dealing with multiple forms at once.

A :java:ref:`FormCollection <FormCollectionInterface>` class accepts :java:ref:`InnerForm
<InnerFormInterface>`

This makes it possible:

    - for forms to depend on each other
        - that is a form A cannot be validated before form B is validated.
        - that is a form A cannot be saved before form B is saved.
    - multiple forms get validated together.
    - multiple forms get saved together.


Usage
*****

To use this library is very easy

- Create :java:ref:`InnerForm <InnerFormInterface>` class

In this example, the DependOnBasicForm requires the BasicForm to have been validated on the
validation stage and be saved on saving stage.

.. code-block:: java

     private class BasicForm extends InnerForm {
            public BasicForm() {
                super();
            }

            public BasicForm(ValidatorInterface validator) {
                super(validator);
            }

            @Override
            public String getIdentifier() {
                return "basic_form_id";
            }

            @Override
            public void save() throws FormException {
                // implement the saving logic, you have access to
                // getValues() returns a map of where key is the name of the field and the values
            }
    }

     private class DependOnBasicForm extends InnerForm {
            public DependOnBasicForm() {
                super();
            }

            public DependOnBasicForm(ValidatorInterface validator) {
                super(validator);
            }

            @Override
            public void save() throws FormException {
                // implement the saving logic, you have access to
                // getValues() returns a map of where key is the name of the field and the values
            }


            @Override
            public String getIdentifier() {
                return "depend_on_basic_form_id";
            }

            @Override
            public String[] requires() {
                return new String[]{"basic_form_id"}; // make this form depend on the basicform
            }
    }

- Create :java:ref:`FormCollectionInterface <FormCollectionInterface>` object

.. code-block:: java

    FormCollection formCollection = new FormCollection();

- Add :java:ref:`InnerForm <InnerFormInterface>` to :java:ref:`FormCollection<FormCollectionInterface>`.

.. code-block:: java

    // create instance of inner form
    BasicForm basicform = new BasicForm();
    DependOnBasicForm dependOnBasicForm = new DependOnBasicForm();

    // add inner form to collection
    formCollection.addForm(basicform);
    formCollection.addForm(dependOnBasicForm);

- Run :java:ref:`validation <FormInterface.isValid()>` and get the :java:ref:`values <FormInterface.getValues()>`.

.. code-block:: java

    if(formCollection.isValid()){
        formCollection.getValues()// returns a map of where key is the name of the field and the values

    }else{

         LinearLayout errorSpace = (LinearLayout) findViewById(R.id.error_base);
         errorSpace.removeAllViews();// clear space first

         ErrorRenderer errorRenderer = new ErrorRenderer(this, formCollection.getValidator());
         errorRenderer.render(errorSpace);
    }

- :java:ref:`Save <FormInterface.save()>` form :java:ref:`values <FormInterface.getValues()>`

.. code-block:: java

    if(formCollection.isValid()){
        try{
            formCollection.save() // save
        } catch (FormException e) {
            e.printStackTrace();
        }

    }else{

        LinearLayout errorSpace = (LinearLayout) findViewById(R.id.error_base);
        errorSpace.removeAllViews();// clear space first

        ErrorRenderer errorRenderer = new ErrorRenderer(this, formCollection.getValidator());
        errorRenderer.render(errorSpace);
    }

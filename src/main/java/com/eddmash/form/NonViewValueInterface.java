package com.eddmash.form;

import com.eddmash.form.fields.FieldInterface;

public interface NonViewValueInterface {
    /**
     * Add a non view value that need to be returned with the value map returned by
     * {@link FieldInterface getValues() }
     *
     * @param fieldName the identifier to use to locate the field being set.
     * @param value     the value being set, this depends on specific
     *                  {@link FieldInterface field }.consult specific
     *                  {@link FieldInterface field } to find expected value.
     */
    void addNonViewValue(String fieldName, Object value);

    /**
     * Remove a non view value.
     *
     * @param fieldName
     */
    void removeNonViewValue(String fieldName);
}

package org.xcolab.client.admin.exceptions;

import org.xcolab.commons.attributes.exceptions.AttributeNotFoundException;

public class ContestTypeAttributeNotFoundException extends AttributeNotFoundException {

    public ContestTypeAttributeNotFoundException(String name, long additionalId, String locale) {
        super("ContestTypeAttribute '" + name + "' and additionalId '" + additionalId
                + "' could not be found (lang was '" + locale + "')");
    }

}

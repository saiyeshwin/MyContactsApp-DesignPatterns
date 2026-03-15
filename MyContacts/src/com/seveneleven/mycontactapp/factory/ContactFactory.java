package com.seveneleven.mycontactapp.factory;
import com.seveneleven.mycontactapp.builder.ContactBuilder;
import com.seveneleven.mycontactapp.contact.*;
public class ContactFactory {
    public static Contact createContact(String type, ContactBuilder builder) {
        if (type.equalsIgnoreCase("person")) {
            return builder.buildPerson();
        }
        else if (type.equalsIgnoreCase("organization")) {
            return builder.buildOrganization();
        }
        else {
            throw new IllegalArgumentException("Invalid contact type");
        }
    }
}
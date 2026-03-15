package com.seveneleven.mycontactapp.search;
import com.seveneleven.mycontactapp.contact.*;
public class EmailCriteria implements SearchCriteria {
    private String email;
    public EmailCriteria(String email) {
        this.email = email.toLowerCase();
    }
    public boolean matches(Contact contact) {
        for (EmailAddress e : contact.getEmails()) {
            if (e.getEmail().toLowerCase().contains(email)) {
                return true;
            }
        }
        return false;
    }
}
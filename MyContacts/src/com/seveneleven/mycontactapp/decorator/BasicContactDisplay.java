package com.seveneleven.mycontactapp.decorator;
import com.seveneleven.mycontactapp.contact.Contact;
public class BasicContactDisplay implements ContactDisplay {
    private Contact contact;
    public BasicContactDisplay(Contact contact) {
        this.contact = contact;
    }
    public String display() {
        return contact.toString();
    }
}
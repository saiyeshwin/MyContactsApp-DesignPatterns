package com.seveneleven.mycontactapp.observer;
import com.seveneleven.mycontactapp.contact.Contact;
public interface ContactObserver {
    void update(Contact contact);
}
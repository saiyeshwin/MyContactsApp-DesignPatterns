package com.seveneleven.mycontactapp.observer;
import com.seveneleven.mycontactapp.contact.Contact;
public class DeletionLoggerObserver implements ContactObserver {
    public void update(Contact contact) {
        System.out.println("Observer: Contact deleted -> " + contact.getName());

    }
}
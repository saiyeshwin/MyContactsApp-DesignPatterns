package com.seveneleven.mycontactapp.contact;
import java.util.ArrayList;
import java.util.List;
import com.seveneleven.mycontactapp.observer.*;
public class ContactManager implements ContactSubject {
    private List<Contact> contacts = new ArrayList<>();
    private List<ContactObserver> observers = new ArrayList<>();
    private Contact deletedContact;
    public void addContact(Contact contact) {
        contacts.add(contact);
    }
    public List<Contact> getContacts() {
        return contacts;
    }
    public void deleteContact(int index) {
        if(index >= 0 && index < contacts.size()) {
            deletedContact = contacts.remove(index);
            notifyObservers();
            System.out.println("Contact deleted successfully.");
        }
    }
    public void addObserver(ContactObserver observer) {
        observers.add(observer);
    }
    public void removeObserver(ContactObserver observer) {
        observers.remove(observer);
    }
    public void notifyObservers() {
        for(ContactObserver o : observers) {
            o.update(deletedContact);
        }
    }
}
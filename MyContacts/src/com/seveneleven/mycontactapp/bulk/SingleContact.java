package com.seveneleven.mycontactapp.bulk;
import com.seveneleven.mycontactapp.contact.Contact;
import com.seveneleven.mycontactapp.contact.ContactManager;

public class SingleContact implements ContactComponent {
    private Contact contact;
    private ContactManager manager;
    public SingleContact(Contact contact, ContactManager manager) {
        this.contact = contact;
        this.manager = manager;
    }
    public void export() {
        System.out.println(contact);
    }
    public void delete() {
        manager.getContacts().remove(contact);
        System.out.println("Deleted: " + contact.getName());
    }
    public Contact getContact() {
        return contact;
    }
}
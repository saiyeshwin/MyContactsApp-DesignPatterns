package com.seveneleven.mycontactapp.bulk;
import java.util.ArrayList;
import java.util.List;
public class ContactGroup implements ContactComponent {
    private List<ContactComponent> contacts = new ArrayList<>();
    public void add(ContactComponent component) {
        contacts.add(component);
    }
    public void remove(ContactComponent component) {
        contacts.remove(component);
    }
    public void export() {
        for (ContactComponent c : contacts) {
            c.export();
        }
    }
    public void delete() {
        for (ContactComponent c : contacts) {
            c.delete();
        }
        System.out.println("Bulk delete completed.");
    }
    public List<ContactComponent> getContacts() {
        return contacts;
    }
}
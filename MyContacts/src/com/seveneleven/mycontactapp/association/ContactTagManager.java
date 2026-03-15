package com.seveneleven.mycontactapp.association;
import java.util.ArrayList;
import java.util.List;
import com.seveneleven.mycontactapp.contact.Contact;
import com.seveneleven.mycontactapp.tag.Tag;
import com.seveneleven.mycontactapp.observer.TagObserver;
public class ContactTagManager {
    private List<TagObserver> observers = new ArrayList<>();
    public void addObserver(TagObserver observer) {
        observers.add(observer);
    }
    public void addTag(Contact contact, Tag tag) {
        contact.getTags().add(tag);
        for(TagObserver o : observers) {
            o.onTagAdded(contact, tag);
        }
    }
    public void removeTag(Contact contact, Tag tag) {
        contact.getTags().remove(tag);
        for(TagObserver o : observers) {
            o.onTagRemoved(contact, tag);
        }
    }
}
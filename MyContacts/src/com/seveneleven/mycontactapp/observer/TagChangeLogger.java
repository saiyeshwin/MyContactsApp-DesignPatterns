package com.seveneleven.mycontactapp.observer;

import com.seveneleven.mycontactapp.contact.Contact;
import com.seveneleven.mycontactapp.tag.Tag;

public class TagChangeLogger implements TagObserver {

    @Override
    public void onTagAdded(Contact contact, Tag tag) {
        System.out.println("Tag '" + tag.getName() +
                "' added to " + contact.getName());
    }

    @Override
    public void onTagRemoved(Contact contact, Tag tag) {
        System.out.println("Tag '" + tag.getName() +
                "' removed from " + contact.getName());
    }
}
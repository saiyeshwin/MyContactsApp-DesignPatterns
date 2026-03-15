package com.seveneleven.mycontactapp.observer;

import com.seveneleven.mycontactapp.contact.Contact;
import com.seveneleven.mycontactapp.tag.Tag;

public interface TagObserver {

    void onTagAdded(Contact contact, Tag tag);

    void onTagRemoved(Contact contact, Tag tag);

}
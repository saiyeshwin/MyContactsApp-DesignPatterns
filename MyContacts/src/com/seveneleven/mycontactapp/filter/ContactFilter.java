package com.seveneleven.mycontactapp.filter;
import com.seveneleven.mycontactapp.contact.Contact;
public interface ContactFilter {
    boolean apply(Contact contact);

}
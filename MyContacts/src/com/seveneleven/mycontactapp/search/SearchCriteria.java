package com.seveneleven.mycontactapp.search;
import com.seveneleven.mycontactapp.contact.Contact;
public interface SearchCriteria {
    boolean matches(Contact contact);

}
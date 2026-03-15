package com.seveneleven.mycontactapp.search;
import com.seveneleven.mycontactapp.contact.Contact;
public class NameCriteria implements SearchCriteria {
    private String keyword;
    public NameCriteria(String keyword) {
        this.keyword = keyword.toLowerCase();
    }
    public boolean matches(Contact contact) {
        return contact.getName().toLowerCase().contains(keyword);
    }
}
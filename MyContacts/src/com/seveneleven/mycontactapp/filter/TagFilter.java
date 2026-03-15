package com.seveneleven.mycontactapp.filter;
import com.seveneleven.mycontactapp.contact.Contact;
public class TagFilter implements ContactFilter {
    private String tag;
    public TagFilter(String tag) {
        this.tag = tag.toLowerCase();
    }
    public boolean apply(Contact contact) {
        return contact.getName().toLowerCase().contains(tag);
    }
}
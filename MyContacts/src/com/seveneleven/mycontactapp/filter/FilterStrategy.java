package com.seveneleven.mycontactapp.filter;
import java.util.List;
import com.seveneleven.mycontactapp.contact.Contact;
public interface FilterStrategy {
    boolean apply(List<ContactFilter> filters, Contact contact);
}
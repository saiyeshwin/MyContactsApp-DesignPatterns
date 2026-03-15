package com.seveneleven.mycontactapp.filter;
import java.util.List;
import com.seveneleven.mycontactapp.contact.Contact;
public class AndFilterStrategy implements FilterStrategy {
    public boolean apply(List<ContactFilter> filters, Contact contact) {
        for(ContactFilter f : filters) {
            if(!f.apply(contact))
                return false;
        }
        return true;
    }
}
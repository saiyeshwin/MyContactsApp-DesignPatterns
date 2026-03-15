package com.seveneleven.mycontactapp.filter;
import java.util.ArrayList;
import java.util.List;
import com.seveneleven.mycontactapp.contact.Contact;
public class CompositeFilter implements ContactFilter {
    private List<ContactFilter> filters = new ArrayList<>();
    private FilterStrategy strategy;
    public CompositeFilter(FilterStrategy strategy) {
        this.strategy = strategy;
    }
    public void addFilter(ContactFilter filter) {
        filters.add(filter);
    }
    public boolean apply(Contact contact) {
        return strategy.apply(filters, contact);
    }
}
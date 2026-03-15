package com.seveneleven.mycontactapp.search;
import java.util.ArrayList;
import java.util.List;
import com.seveneleven.mycontactapp.contact.Contact;
public class SearchHandler {
    private List<SearchCriteria> criteriaList = new ArrayList<>();
    public void addCriteria(SearchCriteria criteria) {
        criteriaList.add(criteria);
    }
    public List<Contact> filter(List<Contact> contacts) {
        List<Contact> results = new ArrayList<>();
        for (Contact contact : contacts) {
            boolean matches = true;
            for (SearchCriteria criteria : criteriaList) {
                if (!criteria.matches(contact)) {
                    matches = false;
                    break;
                }
            }
            if (matches) {
                results.add(contact);
            }
        }
        return results;
    }
}
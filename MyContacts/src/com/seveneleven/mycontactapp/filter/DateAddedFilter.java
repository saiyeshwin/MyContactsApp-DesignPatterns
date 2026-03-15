package com.seveneleven.mycontactapp.filter;
import com.seveneleven.mycontactapp.contact.Contact;
import java.time.LocalDateTime;
public class DateAddedFilter implements ContactFilter {
    private LocalDateTime afterDate;
    public DateAddedFilter(LocalDateTime afterDate) {
        this.afterDate = afterDate;
    }
    public boolean apply(Contact contact) {
        return contact.getCreatedAt().isAfter(afterDate);
    }
}
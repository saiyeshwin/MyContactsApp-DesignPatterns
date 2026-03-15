package com.seveneleven.mycontactapp.search;
import com.seveneleven.mycontactapp.contact.*;
public class PhoneCriteria implements SearchCriteria {
    private String number;
    public PhoneCriteria(String number) {
        this.number = number;
    }
    public boolean matches(Contact contact) {
        for (PhoneNumber p : contact.getPhones()) {
            if (p.getNumber().contains(number)) {
                return true;
            }
        }
        return false;
    }
}
package com.seveneleven.mycontactapp.contact;
import java.util.ArrayList;
import java.util.List;
public class ContactMemento {
    private String name;
    private List<PhoneNumber> phones;
    private List<EmailAddress> emails;
    public ContactMemento(String name,List<PhoneNumber> phones,List<EmailAddress> emails) {
        this.name = name;
        this.phones = phones;
        this.emails = emails;
    }
    public String getName() { return name; }
    public List<PhoneNumber> getPhones() { return phones; }
    public List<EmailAddress> getEmails() { return emails; }
}
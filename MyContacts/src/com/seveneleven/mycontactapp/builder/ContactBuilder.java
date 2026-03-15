package com.seveneleven.mycontactapp.builder;
import java.util.*;
import com.seveneleven.mycontactapp.contact.*;
public class ContactBuilder {
    private String name;
    private List<PhoneNumber> phones = new ArrayList<>();
    private List<EmailAddress> emails = new ArrayList<>();

    public ContactBuilder setName(String name) {
        this.name = name;
        return this;
    }
    public ContactBuilder addPhone(String number, String label) {
        phones.add(new PhoneNumber(number, label));
        return this;
    }
    public ContactBuilder addEmail(String email, String label) {
        emails.add(new EmailAddress(email, label));
        return this;
    }
    public Contact buildPerson() {
        return new PersonContact(name, phones, emails);
    }
    public Contact buildOrganization() {
        return new OrganizationContact(name, phones, emails);
    }
}
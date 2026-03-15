package com.seveneleven.mycontactapp.contact;
import java.time.LocalDateTime;
import java.util.*;
public abstract class Contact {
	private UUID id;
	private String name;
	private List<PhoneNumber> phones;
	private List<EmailAddress> emails;
    private LocalDateTime createdAt;
    public Contact(String name,List<PhoneNumber> phones,List<EmailAddress> emails) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.phones = phones;
        this.emails = emails;
        this.createdAt = LocalDateTime.now();
    }
    public UUID getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public List<PhoneNumber> getPhones() {
        return phones;
    }
    public List<EmailAddress> getEmails() {
        return emails;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
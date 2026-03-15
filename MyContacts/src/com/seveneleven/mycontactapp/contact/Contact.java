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
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ID: ").append(id).append("\n");
		sb.append("Name: ").append(name).append("\n");
		sb.append("Phones:\n");
		for (PhoneNumber p : phones) {
			sb.append("- ").append(p.getNumber()).append("\n");
		}
		sb.append("Emails:\n");
		for (EmailAddress e : emails) {
			sb.append("- ").append(e.getEmail()).append("\n");
		}
		return sb.toString();
	}
	public ContactMemento save() {
	    return new ContactMemento(name, phones, emails);
	}

	public void restore(ContactMemento memento) {
	    this.name = memento.getName();
	    this.phones = memento.getPhones();
	    this.emails = memento.getEmails();
	}
	public void setName(String name) {
		this.name=name;
		
	}
}
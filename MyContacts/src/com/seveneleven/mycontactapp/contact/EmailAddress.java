package com.seveneleven.mycontactapp.contact;
public class EmailAddress {
    private String email;
    private String label;
    public EmailAddress(String email, String label) {
        this.email = email;
        this.label = label;
    }
    public String getEmail() {
        return email;
    }
    public String getLabel() {
        return label;
    }
}
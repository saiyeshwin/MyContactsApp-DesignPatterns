package com.seveneleven.mycontactapp.contact;
public class PhoneNumber {
    private String number;
    private String label;
    public PhoneNumber(String number, String label) {
        this.number = number;
        this.label = label;
    }
    public String getNumber() {
        return number;
    }
    public String getLabel() {
        return label;
    }
}
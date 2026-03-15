package com.seveneleven.mycontactapp.decorator;
public abstract class ContactDisplayDecorator implements ContactDisplay {
    protected ContactDisplay decoratedDisplay;
    public ContactDisplayDecorator(ContactDisplay decoratedDisplay) {
        this.decoratedDisplay = decoratedDisplay;
    }
    public String display() {
        return decoratedDisplay.display();
    }
}
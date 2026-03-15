package com.seveneleven.mycontactapp.decorator;
public class PrettyFormatDecorator extends ContactDisplayDecorator {
    public PrettyFormatDecorator(ContactDisplay decoratedDisplay) {
        super(decoratedDisplay);
    }
    public String display() {
        return "\n-----Contact Details-----\n"
                + decoratedDisplay.display()
                + "-------------------------\n";
    }
}
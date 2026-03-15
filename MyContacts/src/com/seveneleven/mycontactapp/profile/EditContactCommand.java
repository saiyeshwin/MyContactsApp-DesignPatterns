package com.seveneleven.mycontactapp.profile;
import com.seveneleven.mycontactapp.contact.Contact;
import com.seveneleven.mycontactapp.contact.ContactMemento;
public class EditContactCommand implements Command {
    private Contact contact;
    private String newName;
    private ContactMemento backup;
    public EditContactCommand(Contact contact, String newName) {
        this.contact = contact;
        this.newName = newName;
    }
    public void execute() {
        backup = contact.save();
        contact.setName(newName);
        System.out.println("Contact updated successfully.");
    }
}
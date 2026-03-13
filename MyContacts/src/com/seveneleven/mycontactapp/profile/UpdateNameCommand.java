package com.seveneleven.mycontactapp.profile;

import com.seveneleven.mycontactapp.user.User;

public class UpdateNameCommand implements Command {
    private User user;
    private String newName;

    public UpdateNameCommand(User user, String newName) {
        this.user = user;
        this.newName = newName;
    }

    @Override
    public void execute() {
        user.setName(newName);
        System.out.println("Name updated successfully.");
    }
}
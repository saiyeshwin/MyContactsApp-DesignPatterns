package com.seveneleven.mycontactapp.profile;

import com.seveneleven.mycontactapp.security.PasswordUtil;
import com.seveneleven.mycontactapp.validation.Validator;
import com.seveneleven.mycontactapp.user.User;

public class ChangePasswordCommand implements Command {
    private User user;
    private String newPassword;
    public ChangePasswordCommand(User user, String newPassword) {
        this.user = user;
        this.newPassword = newPassword;
    }
    public void execute() throws Exception {
        if (!Validator.isValidPassword(newPassword)) {
            throw new IllegalArgumentException("Weak password!");
        }
        String hash = PasswordUtil.hash(newPassword);
        user.setPasswordHash(hash);
        System.out.println("Password updated successfully.");
    }
}
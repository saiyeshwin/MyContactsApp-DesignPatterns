package com.seveneleven.mycontactapp.auth;

import com.seveneleven.mycontactapp.security.*;
import com.seveneleven.mycontactapp.session.SessionManager;
import com.seveneleven.mycontactapp.user.User;

public class BasicAuth implements Authentication {

    private User storedUser;

    public BasicAuth(User storedUser) {
        this.storedUser = storedUser;
    }
    public boolean authenticate(String email, String password) throws Exception {
        String hashedPassword = PasswordUtil.hash(password);

        if (storedUser.getEmail().equals(email) && storedUser.getPasswordHash().equals(hashedPassword)) {
            System.out.println("Login Successful!");
            SessionManager.getInstance().createSession(email);
            return true;
        }
        System.out.println("Invalid Credentials!");
        return false;
    }
}
package com.seveneleven.mycontactapp.auth;

import com.seveneleven.mycontactapp.session.SessionManager;
import com.seveneleven.mycontactapp.user.User;
public class OAuth implements Authentication {
    private User storedUser;
    public OAuth(User storedUser) {
        this.storedUser = storedUser;
    }
    public boolean authenticate(String email, String password) {

        if (email.equalsIgnoreCase(storedUser.getEmail()) && email.endsWith("@gmail.com")) {
            System.out.println("OAuth Login Successful via Google!");
            SessionManager.getInstance().createSession(email);
            return true;
        }
        System.out.println("OAuth Login Failed!");
        return false;
    }
}
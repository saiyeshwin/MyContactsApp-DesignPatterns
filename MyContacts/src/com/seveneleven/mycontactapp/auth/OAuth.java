package com.seveneleven.mycontactapp.auth;

import com.seveneleven.mycontactapp.session.SessionManager;

public class OAuth implements Authentication {

    @Override
    public boolean authenticate(String email, String password) {

        if (email.endsWith("@gmail.com")) {

            System.out.println("OAuth Login Successful via Google!");

            SessionManager.getInstance().createSession(email);

            return true;
        }

        System.out.println("OAuth Failed!");
        return false;
    }
}
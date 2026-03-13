package com.seveneleven.mycontactapp.session;

public class SessionManager {

    private static SessionManager instance;
    private String loggedInUser;

    private SessionManager() {}

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public void createSession(String email) {
        loggedInUser = email;
        System.out.println("Session created for: " + email);
    }

    public String getLoggedInUser() {
        return loggedInUser;
    }

    public void logout() {
        loggedInUser = null;
        System.out.println("User logged out.");
    }
}
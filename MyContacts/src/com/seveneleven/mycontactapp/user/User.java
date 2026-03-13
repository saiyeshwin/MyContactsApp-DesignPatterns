package com.seveneleven.mycontactapp.user;

public class User {

    protected String name;
    protected String email;
    protected String passwordHash;
    protected String userType;
    protected String preference;

    public User(String name, String email, String passwordHash, String userType) {
        this.name = name;
        this.email = email;
        this.passwordHash = passwordHash;
        this.userType = userType;
    }

    // Getters
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPasswordHash() { return passwordHash; }
    public String getUserType() { return userType; }
    public String getPreference() { return preference; }

    // Profile setters
    public void setName(String name) {
        this.name = name;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public void setPreference(String preference) {
        this.preference = preference;
    }
}
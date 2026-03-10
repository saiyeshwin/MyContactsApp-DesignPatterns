package com.seveneleven.mycontactapp.user;
public class User {
	protected String name;
	protected String email;
	protected String passwordHash;
	protected String userType;

	public User(String name, String email, String passwordHash, String userType) {
		this.name = name;
		this.email = email;
		this.passwordHash = passwordHash;
		this.userType = userType;
	}

	// Getters
	public String getName() { 
		return name; 
	}
	public String getEmail() { 
		return email; 
	}
	public String getPasswordHash() { 
		return passwordHash; 
	}
	public String getUserType() { 
		return userType; 
	}
}
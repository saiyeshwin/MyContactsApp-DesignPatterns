package com.seveneleven.mycontactapp.user;
public class FreeUser extends User {
	public FreeUser(String email, String passwordHash, String name) {
		super(name, email, passwordHash, "FREE");
	}

	public FreeUser(User user) {
		super(user.name,user.email, user.passwordHash,"FREE");
	}
}
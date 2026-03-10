package com.seveneleven.mycontactapp.user;

public class PremiumUser extends User {
	public PremiumUser(String email, String passwordHash, String name) {
		super(name, email, passwordHash,"PREMIUM");
	}

	public PremiumUser(User user) {
		super(user.name, user.email,user.passwordHash, "PREMIUM");
	}
}

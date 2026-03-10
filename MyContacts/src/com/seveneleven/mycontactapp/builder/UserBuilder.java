package com.seveneleven.mycontactapp.builder;
import com.seveneleven.mycontactapp.user.User;

public class UserBuilder {
	private String name;
	private String email;
	private String passwordHash;
	private String userType;

	public UserBuilder setName(String name) {
		this.name = name;
		return this;
	}

	public UserBuilder setEmail(String email) {
		this.email = email;
		return this;
	}

	public UserBuilder setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
		return this;
	}

	public UserBuilder setUserType(String userType) {
		this.userType = userType;
		return this;
	}

	public User build() {
		return new User(name, email, passwordHash, userType);
	}
}
package com.seveneleven.mycontactapp.factory;

import com.seveneleven.mycontactapp.user.*;

public class UserFactory {
	public static User createUser(User user) {
		if (user.getUserType().equalsIgnoreCase("free")) return new FreeUser(user);   // Wrap base user 
		else return new PremiumUser(user);
	}
}
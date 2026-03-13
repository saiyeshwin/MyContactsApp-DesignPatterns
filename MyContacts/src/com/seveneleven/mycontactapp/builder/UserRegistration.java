package com.seveneleven.mycontactapp.builder;

import com.seveneleven.mycontactapp.factory.UserFactory;
import com.seveneleven.mycontactapp.security.PasswordUtil;
import com.seveneleven.mycontactapp.user.User;
import com.seveneleven.mycontactapp.validation.Validator;

public class UserRegistration {
    public User register(String name, String email, String password,String userType) throws Exception {

        if (!Validator.isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid email!");
        }
        if (!Validator.isValidPassword(password)) {
            throw new IllegalArgumentException("Weak password!");
        }
        User user = new UserBuilder()
                .setName(name)
                .setEmail(email)
                .setUserType(userType)
                .setPasswordHash(PasswordUtil.hash(password))
                .build();
        return UserFactory.createUser(user);
    }
}
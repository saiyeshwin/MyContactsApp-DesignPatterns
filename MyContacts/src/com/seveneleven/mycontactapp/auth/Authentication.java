package com.seveneleven.mycontactapp.auth;

public interface Authentication {

    boolean authenticate(String email, String password) throws Exception;

}
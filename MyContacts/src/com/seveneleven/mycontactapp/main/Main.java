// UC-02: User Authentication
// Allow new users to register and login using credentials
// @author Developer
// @version 2.0

package com.seveneleven.mycontactapp.main;

import java.util.Scanner;

import com.seveneleven.mycontactapp.auth.Authentication;
import com.seveneleven.mycontactapp.auth.BasicAuth;
import com.seveneleven.mycontactapp.auth.OAuth;
import com.seveneleven.mycontactapp.builder.UserRegistration;
import com.seveneleven.mycontactapp.user.User;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Email: ");
            String email = sc.nextLine();
            System.out.print("Enter Password: ");
            String password = sc.nextLine();
            System.out.print("Enter User Type (FREE/PREMIUM): ");
            String userType = sc.nextLine();
            UserRegistration service = new UserRegistration();
            User user = service.register(name, email, password, userType);
            System.out.println("\nRegistration Successful!");
            System.out.println("Name: " + user.getName());
            System.out.println("Email: " + user.getEmail());
            System.out.println("User Type: " + user.getUserType());

            System.out.println("\nLogin Now");
            System.out.print("Enter Email: ");
            String loginEmail = sc.nextLine();
            System.out.print("Enter Password: ");
            String loginPassword = sc.nextLine();
            System.out.print("Login Method (BASIC/OAUTH): ");
            String method = sc.nextLine();
            Authentication auth;
            if (method.equalsIgnoreCase("OAUTH")) {
                auth = new OAuth();
            } 
            else {
                auth = new BasicAuth(user);
            }
            boolean result = auth.authenticate(loginEmail, loginPassword);
            if (result) {
                System.out.println("Access granted to contact list.");
            } 
            else {
                System.out.println("Access denied.");
            }

        } 
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
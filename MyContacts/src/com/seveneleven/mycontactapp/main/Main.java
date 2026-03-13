// UC-01: User Registration
// Actor: New User
// Description: User creates an account with email, password, and profile information
//
// UC-02: User Authentication
// Actor: Registered User
// Description: User logs in with credentials to access their contact list
//
// UC-03: User Profile Management
// Actor: Logged-in User
// Description: User updates profile information, changes password, or manages preferences
//
// OOP Concepts:
// Encapsulation (User class)
// Polymorphism via Authentication interface
//
// Design Patterns:
// Builder Pattern (User creation)
// Factory Pattern (FreeUser / PremiumUser)
// Strategy Pattern (Authentication methods)
// Singleton Pattern (SessionManager)
// Command Pattern (Profile update operations)
//
// Java Concepts:
// Input validation
// Exception handling
// Password hashing using MessageDigest
// Regular expressions for email validation
//
// @author Developer
// @version 1.2

package com.seveneleven.mycontactapp.main;

import java.util.Scanner;

import com.seveneleven.mycontactapp.auth.Authentication;
import com.seveneleven.mycontactapp.auth.BasicAuth;
import com.seveneleven.mycontactapp.auth.OAuth;
import com.seveneleven.mycontactapp.builder.UserRegistration;
import com.seveneleven.mycontactapp.profile.*;
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
			boolean authenticated = auth.authenticate(loginEmail, loginPassword);
			if (!authenticated) {
				System.out.println("Access Denied.");
				return;
			}
			System.out.println("Access granted to contact list.");
			System.out.println("1. Update Name");
			System.out.println("2. Change Password");
			System.out.println("3. Update Preference");
			System.out.print("Choose option: ");
			int option = Integer.parseInt(sc.nextLine());
			ProfileManager manager = new ProfileManager();
			Command command;
			switch (option) {
			    case 1 -> {
			        System.out.print("Enter new name: ");
			        String newName = sc.nextLine();
			        command = new UpdateNameCommand(user, newName);
			        manager.executeCommand(command);
			    }
			    case 2 -> {
			        System.out.print("Enter new password: ");
			        String newPassword = sc.nextLine();
			        command = new ChangePasswordCommand(user, newPassword);
			        manager.executeCommand(command);
			    }
			    case 3 -> {
			        System.out.print("Enter preference: ");
			        String preference = sc.nextLine();
			        command = new UpdatePreferenceCommand(user, preference);
			        manager.executeCommand(command);
			    }
			    default -> System.out.println("Invalid option.");
			}
			
		}
		catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
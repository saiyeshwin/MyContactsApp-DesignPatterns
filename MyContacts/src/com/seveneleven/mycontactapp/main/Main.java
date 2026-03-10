// UC-01: User Registration
// Allow new users to create an account with email, password
// Factory pattern (FreeUser, PremiumUser) and Builder pattern(User object construction) were used
// @author Developer
// @version 1.0
package com.seveneleven.mycontactapp.main;
import java.util.*;
import com.seveneleven.mycontactapp.builder.UserRegistration;
import com.seveneleven.mycontactapp.user.User;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("Enter Name:");
			String name = sc.nextLine();
			System.out.print("Enter Email:");
			String email = sc.nextLine();
			System.out.print("Enter Password:");
			String password = sc.nextLine();
			System.out.print("Enter User Type (FREE/PREMIUM):");
			String userType = sc.nextLine();
			UserRegistration service = new UserRegistration();
			User user = service.register(name,email,password,userType);
			System.out.println("\nRegistration Successful!");
			System.out.println("Name:"+user.getName());
			System.out.println("Email:"+user.getEmail());
			System.out.println("User Type:"+user.getUserType());
		}
		catch (Exception e) {
			System.out.println("Error:"+e.getMessage());
		}
	}
}
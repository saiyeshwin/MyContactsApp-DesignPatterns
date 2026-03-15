// UC-05: View Contact Details
// Allow logged-in users to view complete information of a specific contact
// @author Developer
// @version 5.0

package com.seveneleven.mycontactapp.main;
import java.util.Scanner;
import com.seveneleven.mycontactapp.auth.Authentication;
import com.seveneleven.mycontactapp.auth.BasicAuth;
import com.seveneleven.mycontactapp.auth.OAuth;
import com.seveneleven.mycontactapp.builder.ContactBuilder;
import com.seveneleven.mycontactapp.builder.UserRegistration;
import com.seveneleven.mycontactapp.contact.Contact;
import com.seveneleven.mycontactapp.decorator.*;
import com.seveneleven.mycontactapp.factory.ContactFactory;
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
            
            System.out.println("\nLogin");
            System.out.print("Login Method (BASIC/OAUTH): ");
            String method = sc.nextLine();
            Authentication auth;
            boolean authenticated;
            if (method.equalsIgnoreCase("BASIC")) {
                System.out.print("Enter Email: ");
                String loginEmail = sc.nextLine();
                System.out.print("Enter Password: ");
                String loginPassword = sc.nextLine();
                auth = new BasicAuth(user);
                authenticated = auth.authenticate(loginEmail, loginPassword);
            } 
            else if (method.equalsIgnoreCase("OAUTH")) {
                System.out.print("Enter Gmail: ");
                String gmail = sc.nextLine();
                auth = new OAuth(user);
                authenticated = auth.authenticate(gmail, "");
            } 
            else {
                System.out.println("Invalid login method.");
                return;
            }
            if (!authenticated) {
                System.out.println("Access Denied.");
                return;
            }
            System.out.println("Access granted to contact list.");
            boolean running = true;
            Contact contact = null;
            while (running) {
                System.out.println("\nMenu:");
                System.out.println("1. Update Name");
                System.out.println("2. Change Password");
                System.out.println("3. Update Preference");
                System.out.println("4. Create Contact");
                System.out.println("5. View Contact");
                System.out.println("6. Exit");
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
                    case 4 -> {
                        System.out.println("\nCreate Contact");
                        System.out.print("Contact Type (PERSON/ORG): ");
                        String type = sc.nextLine();
                        System.out.print("Name: ");
                        String contactName = sc.nextLine();
                        ContactBuilder builder = new ContactBuilder()
                                .setName(contactName);
                        System.out.print("Phone number: ");
                        String phone = sc.nextLine();
                        builder.addPhone(phone, "mobile");
                        System.out.print("Email: ");
                        String mail = sc.nextLine();
                        builder.addEmail(mail, "personal");
                        contact = ContactFactory.createContact(type, builder);
                        System.out.println("\nContact Created!");
                        System.out.println("ID: " + contact.getId());
                        System.out.println("Name: " + contact.getName());
                        System.out.println("Created: " + contact.getCreatedAt());
                    }
                    case 5 -> {
                        if (contact == null) {
                            System.out.println("No contact available.");
                            break;
                        }
                        ContactDisplay display = new BasicContactDisplay(contact);
                        display = new PrettyFormatDecorator(display);
                        System.out.println(display.display());
                    }
                    case 6 -> {
                        System.out.println("Exiting");
                        running = false;
                    }

                    default -> System.out.println("Invalid option.");
                }
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
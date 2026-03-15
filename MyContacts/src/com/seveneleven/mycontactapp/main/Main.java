// UC-08: Bulk Operations (Composite Pattern)
// Allow logged-in users to perform operations on multiple contacts simultaneously
// @author Developer
// @version 8.0
package com.seveneleven.mycontactapp.main;
import java.util.Scanner;
import com.seveneleven.mycontactapp.auth.*;
import com.seveneleven.mycontactapp.builder.*;
import com.seveneleven.mycontactapp.contact.*;
import com.seveneleven.mycontactapp.decorator.*;
import com.seveneleven.mycontactapp.factory.*;
import com.seveneleven.mycontactapp.profile.*;
import com.seveneleven.mycontactapp.user.User;
import com.seveneleven.mycontactapp.observer.*;
import com.seveneleven.mycontactapp.bulk.*;

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
            UserRegistration registration = new UserRegistration();
            User user = registration.register(name, email, password, userType);
            System.out.println("\nRegistration Successful!");
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
            else {
                System.out.print("Enter Gmail: ");
                String gmail = sc.nextLine();
                auth = new OAuth(user);
                authenticated = auth.authenticate(gmail, "");
            }
            if (!authenticated) {
                System.out.println("Access Denied");
                return;
            }
            System.out.println("Access granted.");
            ContactManager manager = new ContactManager();
            manager.addObserver(new DeletionLoggerObserver());
            boolean running = true;
            while (running) {
                System.out.println("\nMENU");
                System.out.println("1 Update Name");
                System.out.println("2 Change Password");
                System.out.println("3 Update Preference");
                System.out.println("4 Create Contact");
                System.out.println("5 View Contacts");
                System.out.println("6 Edit Contact");
                System.out.println("7 Delete Contact");
                System.out.println("8 Bulk Delete Contacts");
                System.out.println("9 Bulk Export Contacts");
                System.out.println("10 Exit");
                System.out.print("Choose option: ");
                int option = Integer.parseInt(sc.nextLine());
                ProfileManager profileManager = new ProfileManager();
                Command command;
                switch (option) {
                    case 1 -> {
                        System.out.print("Enter new name: ");
                        String newName = sc.nextLine();
                        command = new UpdateNameCommand(user, newName);
                        profileManager.executeCommand(command);
                    }
                    case 2 -> {
                        System.out.print("Enter new password: ");
                        String newPassword = sc.nextLine();
                        command = new ChangePasswordCommand(user, newPassword);
                        profileManager.executeCommand(command);
                    }
                    case 3 -> {
                        System.out.print("Enter preference: ");
                        String preference = sc.nextLine();
                        command = new UpdatePreferenceCommand(user, preference);
                        profileManager.executeCommand(command);
                    }
                    case 4 -> {
                        System.out.print("Contact Type (PERSON/ORG): ");
                        String type = sc.nextLine();
                        System.out.print("Name: ");
                        String cname = sc.nextLine();
                        ContactBuilder builder = new ContactBuilder().setName(cname);
                        System.out.print("Phone: ");
                        builder.addPhone(sc.nextLine(), "mobile");
                        System.out.print("Email: ");
                        builder.addEmail(sc.nextLine(), "personal");
                        Contact contact = ContactFactory.createContact(type, builder);
                        manager.addContact(contact);
                        System.out.println("Contact Created!");
                    }
                    case 5 -> {
                        if (manager.getContacts().isEmpty()) {
                            System.out.println("No contacts.");
                            break;
                        }
                        for (Contact c : manager.getContacts()) {
                            ContactDisplay display =
                                    new PrettyFormatDecorator(
                                            new BasicContactDisplay(c));

                            System.out.println(display.display());
                        }
                    }
                    case 6 -> {
                        if (manager.getContacts().isEmpty()) {
                            System.out.println("No contacts.");
                            break;
                        }
                        for (int i = 0; i < manager.getContacts().size(); i++) {
                            System.out.println(i + " : " +
                                    manager.getContacts().get(i).getName());
                        }
                        System.out.print("Select index: ");
                        int index = Integer.parseInt(sc.nextLine());
                        Contact contact = manager.getContacts().get(index);
                        System.out.print("Enter new name: ");
                        String newName = sc.nextLine();
                        EditContactCommand edit =
                                new EditContactCommand(contact, newName);
                        edit.execute();
                    }
                    case 7 -> {
                        for (int i = 0; i < manager.getContacts().size(); i++) {
                            System.out.println(i + " : " +
                                    manager.getContacts().get(i).getName());
                        }
                        System.out.print("Enter index to delete: ");
                        int index = Integer.parseInt(sc.nextLine());
                        manager.deleteContact(index);
                    }

                    case 8 -> {
                        System.out.println("Enter indexes to delete (space separated):");
                        for (int i = 0; i < manager.getContacts().size(); i++) {
                            System.out.println(i + " : " +
                                    manager.getContacts().get(i).getName());
                        }
                        String[] indexes = sc.nextLine().split(" ");
                        ContactGroup group = new ContactGroup();
                        for (String s : indexes) {
                            int idx = Integer.parseInt(s);
                            Contact c = manager.getContacts().get(idx);
                            group.add(new SingleContact(c, manager));
                        }
                        group.delete();
                    }
                    case 9 -> {
                        ContactGroup group = new ContactGroup();
                        for (Contact c : manager.getContacts()) {
                            group.add(new SingleContact(c, manager));
                        }
                        group.export();
                    }
                    case 10 -> {
                        running = false;
                        System.out.println("Exiting");
                    }
                    default -> System.out.println("Invalid option.");
                }
            }

        } 
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
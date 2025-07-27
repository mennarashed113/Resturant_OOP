package Core;

import UI.*;
import models.Users.*;

import services.interfaces.CustomerService;
import services.Implementation.CustomerServiceImpl;
import services.interfaces.UserService;
import services.Implementation.UserServiceImpl;

import java.util.Scanner;

public class App {
    private final Scanner input = new Scanner(System.in);

    public void run() {
        while (true) {
            System.out.println("\n👋 Welcome to the Restaurant System!");
            System.out.println("1. Register (Customers only)");
            System.out.println("2. Login");
            System.out.println("0. Exit");
            System.out.print("Choose your choice: ");

            String choice = input.nextLine();

            switch (choice) {
                case "1" -> registerCustomer();
                case "2" -> {
                    User user = loginUser();
                    if (user == null) {
                        System.out.println(" Login failed.");
                        break;
                    }

                    HandleUser handler = getHandlerForUser(user);
                    if (handler != null) {
                        handler.handleUser(user);
                    } else {
                        System.out.println(" No handler found for this user type.");
                    }
                }
                case "0" -> {
                    System.out.println("👋 Exiting... Goodbye!");
                    return;
                }
                default -> System.out.println(" Invalid choice.");
            }
        }
    }

    private void registerCustomer() {
        System.out.print("Please enter your Username: ");
        String username = input.nextLine();
        System.out.print("Please enter your Password: ");
        String password = input.nextLine();

        CustomerService customerService = new CustomerServiceImpl();
        customerService.register(username, password);
    }

    private User loginUser() {
        System.out.print("Please enter your Username: ");
        String username = input.nextLine();
        System.out.print("Please enter your Password: ");
        String password = input.nextLine();

        UserService userService = new UserServiceImpl();
        return userService.login(username, password);
    }

    private HandleUser getHandlerForUser(User user) {
        if (user instanceof Customer) return new HandleCustomer();
        if (user instanceof Chef) return new HandleChef();
        if (user instanceof DeliveryGuy) return new HandleDeliveryGuy();
        return null;
    }
}

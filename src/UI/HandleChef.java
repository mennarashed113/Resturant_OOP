package UI;

import models.Dish;
import models.Order;
import models.OrderStatus;
import models.SeedData.DishData;
import models.SeedData.OrderData;
import models.Users.Chef;
import models.Users.User;

import services.interfaces.ChefService;
import services.Implementation.ChefServiceImpl;

import java.util.Scanner;

public class HandleChef implements HandleUser {
    @Override
    public void handleUser(User user) {
        if (!(user instanceof Chef chef)) {
            System.out.println("❌ Invalid user role for this handler.");
            return;
        }

        ChefService service = new ChefServiceImpl();
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("\n👨‍🍳 Chef Menu:");
            System.out.println("1. View PENDING Orders");
            System.out.println("2. Mark Order as READY_FOR_DELIVERY");
            System.out.println("3. Add Dish");
            System.out.println("4. Edit Dish");
            System.out.println("0. Logout");
            System.out.print("Your choice: ");
            String choice = input.nextLine();

            switch (choice) {
                case "1" -> service.viewOrders();

                case "2" -> {
                    System.out.println("📦 Existing Orders:");
                    for (Order o : OrderData.orders) {
                        System.out.println("- " + o.getOrderId() + ": " + o.getOrderStatus());
                    }

                    System.out.print("Enter Order ID to mark as READY: ");
                    String orderId = input.nextLine().trim();

                    Order order = OrderData.orders.stream()
                            .filter(o -> o.getOrderId().equalsIgnoreCase(orderId))
                            .findFirst().orElse(null);

                    if (order != null) {
                        service.updateOrderStatus(order, OrderStatus.READY_FOR_DELIVERY);
                    } else {
                        System.out.println(" Order not found.");
                    }
                }

                case "3" -> {
                    System.out.print("Enter Dish Name: ");
                    String name = input.nextLine();
                    System.out.print("Enter Price: ");
                    double price = Double.parseDouble(input.nextLine());
                    String id = "D" + (DishData.dishes.size() + 1);
                    Dish newDish = new Dish(id, name, price);
                    service.createDish(newDish);
                }

                case "4" -> {
                    System.out.print("Enter Dish ID to edit: ");
                    String dishId = input.nextLine();
                    Dish dish = DishData.dishes.stream()
                            .filter(d -> d.getDishId().equalsIgnoreCase(dishId))
                            .findFirst().orElse(null);

                    if (dish != null) {
                        System.out.print("New Name: ");
                        String newName = input.nextLine();
                        System.out.print("New Price: ");
                        double newPrice = Double.parseDouble(input.nextLine());
                        service.editDish(dish, newName, newPrice);
                    } else {
                        System.out.println(" Dish not found.");
                    }
                }

                case "0" -> {
                    System.out.println("👋 Logged out.");
                    return;
                }

                default -> System.out.println("❌ Invalid choice.");
            }
        }
    }
}

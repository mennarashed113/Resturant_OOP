package UI;

import models.Order;
import models.OrderStatus;
import models.SeedData.OrderData;
import models.Users.DeliveryGuy;
import models.Users.User;

import services.interfaces.DeliveryService;
import services.interfaces.DeliveryServiceImpl;

import java.util.Scanner;

public class HandleDeliveryGuy implements HandleUser {
    @Override
    public void handleUser(User user) {
        if (!(user instanceof DeliveryGuy guy)) {
            System.out.println("❌ Invalid user role for this handler.");
            return;
        }

        DeliveryService service = new DeliveryServiceImpl();
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("\n🚚 Delivery Menu:");
            System.out.println("1. View Orders READY_FOR_DELIVERY");
            System.out.println("2. Mark Order as DELIVERED");
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

                    System.out.print("Enter Order ID to mark as DELIVERED: ");
                    String orderId = input.nextLine().trim();

                    Order order = OrderData.orders.stream()
                            .filter(o -> o.getOrderId().equalsIgnoreCase(orderId))
                            .findFirst().orElse(null);

                    if (order != null) {
                        service.updateOrderStatus(order, OrderStatus.DELIVERED);
                    } else {
                        System.out.println("Order not found.");
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

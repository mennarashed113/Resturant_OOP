package UI;

import models.Dish;
import models.Order;
import models.SeedData.DishData;
import models.Users.Customer;
import models.Users.User;
import services.interfaces.CustomerService;
import services.interfaces.CustomerServiceImpl;

import java.util.Scanner;

public class HandleCustomer implements HandleUser {
    @Override
    public void handleUser(User customer) {
        if (!(customer instanceof Customer cust)) {
            System.out.println("❌ Invalid user role for this handler.");
            return;
        }

        CustomerService service = new CustomerServiceImpl(cust);
        Scanner sc = new Scanner(System.in);

        while (true) {
            service.viewMenu();
            System.out.println("Enter Dish ID to order (or type 0 to logout): ");
            String dishId = sc.nextLine();

            if (dishId.equals("0")) {
                System.out.println("👋 Logged out.");
                break;
            }

            Dish dish = DishData.dishes.stream()
                    .filter(d -> d.getDishId().equalsIgnoreCase(dishId))
                    .findFirst()
                    .orElse(null);

            if (dish != null) {
                System.out.print("Enter quantity to order: ");
                int quantity = Integer.parseInt(sc.nextLine());
                Order order = new Order(dish, quantity, cust);
                service.createOrder(order);
            } else {
                System.out.println("❌ Dish not found.");
            }
        }
    }
}
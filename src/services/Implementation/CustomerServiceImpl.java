package services.Implementation;

import models.Dish;
import models.Order;
import models.SeedData.*;
import models.Users.Customer;
import services.interfaces.CustomerService;
import services.interfaces.UserService;

public class CustomerServiceImpl implements CustomerService {
    private Customer customer;

    public CustomerServiceImpl(Customer customer) {
        this.customer = customer;
    }

    public CustomerServiceImpl() {
    }

    @Override
    public void viewMenu() {
          for(Dish dish : DishData.dishes){
              System.out.println(dish);
          }
    }

    @Override
    public void createOrder(Order order) {
      customer.addOrder(order);
      System.out.println(" Order placed: " + order);
    }

    @Override
    public void register(String username, String password) {
        for (Customer customer : UsersData.customers) {
            if (customer.getUsername().equals(username)) {
                System.out.println("Customer username already exists!");
                return;
            }
        }

        Customer newCustomer = new Customer(username, password);
        UsersData.customers.add(newCustomer);
        System.out.println("✅ Registration successful!");

        // Optional: auto-login
        UserService userService = new UserServiceImpl();
        userService.login(username, password);

          }

    }




package models.Users;

import models.Order;
import models.SeedData.OrderData;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User {


    List<Order> orders = new ArrayList<>();

    public Customer(String username, String password) {
        super(username, password);
    }

    public List<Order> getOrders() {
        return orders;
    }

 public void addOrder(Order order) {
        orders.add(order);
     OrderData.orders.add(order);
 }
}

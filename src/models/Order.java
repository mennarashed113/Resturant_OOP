package models;

import models.Users.Customer;

public class Order {
    private static int counter = 1;
    private String  orderId ;
    private  Dish dish;
    private  int quantity;
    private  OrderStatus orderStatus;
    private Customer customer;


    public Order(Dish dish, int quantity,Customer customer) {
        this.orderId = "Order" + counter++;
        this.dish = dish;
        this.quantity = quantity;
        this.orderStatus = OrderStatus.PENDING;
        this.customer = customer;

    }

    public String getOrderId() {
        return orderId;
    }

    public Dish getDish() {
        return dish;
    }

    public int getQuantity() {
        return quantity;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public Customer getCustomer() {
        return customer;
    }


    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return orderId+": "+ dish.getDishName()+ " x"+getQuantity()+ " ["+orderStatus+"]";
    }
}

package services.interfaces;

import models.Dish;
import models.Order;
import models.OrderStatus;
import models.*;
import models.SeedData.DishData;
import models.SeedData.OrderData;
import models.SeedData.UsersData;
import models.Users.Chef;
import models.Users.Customer;
import models.Users.User;


public class ChefServiceImpl implements ChefService {

    @Override
    public void createDish(Dish dish) {
        DishData.dishes.add(dish);
        System.out.println("Dish has been created!");
    }

    @Override
    public void editDish(Dish dish, String newName, double newPrice) {
        if (DishData.dishes.contains(dish)) {
            dish.setDishName(newName);
            dish.setPrice(newPrice);
            System.out.println("✅ Dish has been updated!");
        } else {
            System.out.println("❌ Dish does not exist!");
        }
    }

    @Override
    public void viewOrders() {

        for(Order order : OrderData.orders){
            if(order.getOrderStatus() == OrderStatus.PENDING){
                System.out.println(order);
            }

        }

    }

    @Override
    public void updateOrderStatus(Order order, OrderStatus status) {
         if(OrderData.orders.contains(order)){
             order.setOrderStatus(status);
             System.out.println("Order status has been updated!");
         }
         else {
             System.out.println("Order does not exist!");
         }

    }


}

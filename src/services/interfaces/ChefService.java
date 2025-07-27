package services.interfaces;

import models.Dish;
import models.Order;
import models.OrderStatus;

public interface ChefService  {
    void createDish(Dish dish);
    void editDish(Dish dish, String newName, double newPrice);
    void viewOrders();
    void updateOrderStatus(Order order, OrderStatus status);
}

package services.interfaces;

import models.Order;
import models.OrderStatus;

public interface DeliveryService   {

    void viewOrders() ;

    void updateOrderStatus(Order order, OrderStatus status) ;

}


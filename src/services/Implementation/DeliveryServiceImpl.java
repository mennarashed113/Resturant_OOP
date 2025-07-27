package services.Implementation;

import models.Order;
import models.OrderStatus;
import models.SeedData.OrderData;
import services.interfaces.DeliveryService;

public class DeliveryServiceImpl implements DeliveryService {
    @Override
    public void viewOrders() {
        for(Order order : OrderData.orders){
            if(order.getOrderStatus() == OrderStatus.READY_FOR_DELIVERY){
                System.out.println(order);
            }

        }
    }

    @Override
    public void updateOrderStatus(Order order, OrderStatus status) {
    if(OrderData.orders.contains(order) && order.getOrderStatus() == OrderStatus.READY_FOR_DELIVERY) {
        order.setOrderStatus(status);
        System.out.println("Order Status Updated");

    }
    else{
        System.out.println("Order not ready for delivery or not found");
    }

    }


}

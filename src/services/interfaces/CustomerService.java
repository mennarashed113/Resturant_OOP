package services.interfaces;
import models.*;
public interface CustomerService extends Registerable  {
    public void viewMenu();
    public void createOrder(Order order);

}

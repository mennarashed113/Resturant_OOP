package services.Implementation;

import models.SeedData.UsersData;
import models.Users.Chef;
import models.Users.Customer;
import models.Users.DeliveryGuy;
import models.Users.User;
import services.interfaces.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public User login(String username, String password) {
        for (Customer customer : UsersData.customers) {
            if (customer.getUsername().equals(username) && customer.getPassword().equals(password)) {
                return customer;
            }
        }
        for (Chef chef : UsersData.chefs) {
            if (chef.getUsername().equals(username) && chef.getPassword().equals(password)) {
                return chef;
            }
        }
        for (DeliveryGuy guy : UsersData.deliveryGuys) {
            if (guy.getUsername().equals(username) && guy.getPassword().equals(password)) {
                return guy;
            }
        }
        System.out.println("Invalid login credentials.");
        return null;
    }
}

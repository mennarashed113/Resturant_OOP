package models.SeedData;

import models.Users.Chef;
import models.Users.Customer;
import models.Users.DeliveryGuy;
import models.Users.User;

import java.util.ArrayList;
import java.util.List;

public class UsersData {

    public static List<Customer> customers = new ArrayList<>();
    public static List<Chef> chefs = new ArrayList<>();
    public static List<DeliveryGuy> deliveryGuys = new ArrayList<>();

    static {
        chefs.add(new Chef("chef1", "pass123"));
        deliveryGuys.add(new DeliveryGuy("delivery1", "pass456"));
    }
}

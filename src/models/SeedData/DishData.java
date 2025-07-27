package models.SeedData;

import models.Dish;

import java.util.*;

public class DishData {
    public static List<Dish> dishes = new ArrayList<>();

    static {
        dishes.add(new Dish("D1", "Burger", 5.99));
        dishes.add(new Dish("D2", "Pizza", 7.49));
        dishes.add(new Dish("D3", "Pasta", 6.25));
    }
}

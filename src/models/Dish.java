package models;

public class Dish {

    private  String DishId ;
    private String DishName;
    private  double DishPrice;

    public Dish(String Id,String dishName, double dishPrice) {
        DishId = Id;
        DishName = dishName;
        DishPrice = dishPrice;
    }

    public String  getDishId() {
        return DishId;
    }

    public String getDishName() {
        return DishName;
    }

    public double getDishPrice() {
        return DishPrice;
    }

    @Override
    public String toString() {
        return DishId + ":  " + DishName + " $" + DishPrice;
    }

    public void setDishName(String newName) {
        DishName = newName;
    }

    public void setPrice(double newPrice) {
        DishPrice = newPrice;
    }
}

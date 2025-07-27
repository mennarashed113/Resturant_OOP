# 🍽️ Restaurant System (Java, Console-Based)

This project is a simple restaurant order system using *OOP* and *SOLID* principles.

## 🚀 Features
- Role-based users: Customer, Chef, DeliveryGuy
- Registration (Customer only)
- Login for all users
- Customers can view menu and place orders
- Chefs can manage dishes and mark orders as ready
- Delivery guys can mark orders as delivered , view Ready for Delivery orders

## 📂 Project Structure

Core/             # Main application runner (App.java)

UI/               # Handlers for each user type (HandleCustomer, HandleChef, etc.)

models/           # Data models (Dish, Order, User, etc.)

models/SeedData/  # Seeded Lists for Dishes, Orders, Users

services/         # Interfaces and implementations for logic



## ✅ Example Test Users (Pre-seeded)
- Chef: chef1 / 123
- Delivery: delivery1 / 123
- Dishes: Pizza, Burger, Pasta

Enjoy and feel free to extend the logic!

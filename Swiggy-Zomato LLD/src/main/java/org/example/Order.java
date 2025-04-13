package org.example;

import org.example.restaurant.Dish;
import org.example.restaurant.Restaurant;
import org.example.utils.Location;
import org.example.utils.ORDERSTATUS;

import java.util.HashMap;

public class Order {
    private User user;
    private Restaurant restaurant;
    private HashMap<Dish, Integer> dishes;
    private String discountCode;
    private String paymentId;
    private ORDERSTATUS orderstatus;

    public Order(User user, Restaurant restaurant, HashMap<Dish, Integer> dishes) {
        this.user = user;
        this.restaurant = restaurant;
        this.dishes = dishes;
        this.orderstatus = ORDERSTATUS.PLACED;
    }

    public Order(User user, Restaurant restaurant, HashMap<Dish, Integer> dishes, String discountCode, String paymentId) {
        this.user = user;
        this.restaurant = restaurant;
        this.dishes = dishes;
        this.discountCode = discountCode;
        this.paymentId = paymentId;
        this.orderstatus = ORDERSTATUS.PLACED;
    }

    public String getUserId() {
        return user.getId();
    }

    public String getRestaurantId() {
        return restaurant.getId();
    }

    public HashMap<Dish, Integer> getDishes() {
        return dishes;
    }

    public Location getUserLocation() {
        return user.getLocation();
    }

    public Location getRestaurantLocation() {
        return restaurant.getLocation();
    }
}

package org.example.restaurant;

import org.example.utils.CUISINE;

import java.util.ArrayList;
import java.util.List;

public class Dish {
    private String name;
    private CUISINE cuisine;
    private String description;
    private double price;
    private List<String> dishImages;
    private List<DishAddOn> addons;

    public Dish(String name, CUISINE cuisine, double price) {
        this.name = name;
        this.cuisine = cuisine;
        this.price = price;
        dishImages = new ArrayList<>();
        addons = new ArrayList<>();
    }

    public void addAddOn(DishAddOn dishAddOn) {
        addons.add(dishAddOn);
    }

    public double getPrice() {
        double finalPrice = price;
        for (DishAddOn addOn : addons) {
            finalPrice += addOn.getPrice();
        }
        return finalPrice;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public CUISINE getCuisine() {
        return cuisine;
    }
}

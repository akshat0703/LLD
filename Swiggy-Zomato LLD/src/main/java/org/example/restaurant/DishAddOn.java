package org.example.restaurant;

import java.util.ArrayList;
import java.util.List;

public class DishAddOn {
    private String name;
    private String description;
    private double price;
    private boolean isAvail;
    private List<String> images;

    public DishAddOn(String name, double price) {
        this.name = name;
        this.price = price;
        images = new ArrayList<>();
    }

    //getters and setters

    public double getPrice() {
        return price;
    }
}

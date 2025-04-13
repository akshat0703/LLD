package org.example.restaurant;

import org.example.notifications.NotificationMgr;
import org.example.utils.Location;

import java.util.HashMap;

import static java.lang.Thread.sleep;

public class Restaurant {
    private String name;
    private boolean isAvail;
    private Location location;
    private Menu menu;
    private RestaurantOwner restaurantOwner;

    public Restaurant(String name, RestaurantOwner restaurantOwner, Location location) {
        this.name = name;
        this.restaurantOwner = restaurantOwner;
        this.location = location;
        isAvail = false;
        menu = null;
    }

    public void addMenu(Menu menu) {
        this.menu = menu;
    }

    public String getId() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    public boolean prepareFood(String orderId, HashMap<Dish, Integer> dishes)  {
        System.out.println("Restaurant accepted the order and starting to prepare it.");

        NotificationMgr notificationMgr = NotificationMgr.getNotificationMgr();

        notificationMgr.notify(orderId, "Food is being prepared in restaurant.");
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        notificationMgr.notify(orderId, "Food is ready and can be picked up from restaurant.");

        return true;
    }
}

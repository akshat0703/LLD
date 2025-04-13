package org.example.restaurant;

import java.util.HashMap;

public class RestaurantMgr {
    private RestaurantMgr() {
        restaurantMap = new HashMap<>();
    }

    private static RestaurantMgr restaurantMgrInstance;
    private HashMap<String, Restaurant> restaurantMap = null;

    public static RestaurantMgr getRestaurantMgr() {
        if(restaurantMgrInstance == null) {
            restaurantMgrInstance = new RestaurantMgr();
        }
        return restaurantMgrInstance;
    }

    public void addRestaurant(String restaurantName, Restaurant restaurant) {
        restaurantMap.put(restaurantName, restaurant);
    }

    public Restaurant getRestaurant(String restaurant) {
        return restaurantMap.get(restaurant);
    }
}

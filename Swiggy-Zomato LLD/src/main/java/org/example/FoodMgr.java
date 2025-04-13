package org.example;

import org.example.notifications.NotificationMgr;
import org.example.notifications.PushNotificationSender;
import org.example.restaurant.Dish;
import org.example.restaurant.Restaurant;
import org.example.restaurant.RestaurantMgr;

import java.util.HashMap;

public class FoodMgr {
    private FoodMgr() {

    }

    private static FoodMgr foodMgrInstance;

    public static FoodMgr getFoodMgr() {
        if(foodMgrInstance == null) {
            foodMgrInstance = new FoodMgr();
        }
        return foodMgrInstance;
    }

    public void prepareFood(String orderId, String restaurantId, HashMap<Dish, Integer> dishes) {
        RestaurantMgr restaurantMgr = RestaurantMgr.getRestaurantMgr();
        Restaurant restaurant = restaurantMgr.getRestaurant(restaurantId);
        restaurant.prepareFood(orderId, dishes);

        // Restaurant should receive the delivery partner's notifications
        // The order in which the restaurant, user and delivery partner are added to the notification mgr
        // will decide which notifications they receive
        // For interviews, This is too much detailing though, we can just mention to interviewer and move forward
        addRestaurantForNotificationUpdates(orderId, restaurantId);
    }

    public void addRestaurantForNotificationUpdates(String orderId, String restaurantId) {
        NotificationMgr notificationMgr = NotificationMgr.getNotificationMgr();
        // We can add push or whatsapp notifications in same way. Basically, we are keeping all notifications custom
        notificationMgr.addNotificationSender(orderId, restaurantId, new PushNotificationSender());
    }
}

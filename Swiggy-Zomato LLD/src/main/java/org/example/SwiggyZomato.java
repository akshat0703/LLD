package org.example;

import org.example.delivery.DeliveryPartner;
import org.example.delivery.DeliveryPartnerMgr;
import org.example.restaurant.*;
import org.example.utils.CUISINE;
import org.example.utils.Location;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class SwiggyZomato {
    public static void main(String[] args) {

        // Chinese Restaurant
        RestaurantOwner owner1 = new RestaurantOwner("Owner1");
        Restaurant chineseRest = new Restaurant("Chini", owner1, new Location(1, 1));
        Dish noodles = new Dish("noodles", CUISINE.CHINESE, 200);
        noodles.addAddOn(new DishAddOn("premium Sauce", 20));
        Dish friedRice = new Dish("Fried Rice", CUISINE.CHINESE, 180);
        Dish springRolls = new Dish("Spring Rolls", CUISINE.CHINESE, 120);
        Menu chineseMenu = new Menu(new ArrayList<>(Arrays.asList(noodles, friedRice, springRolls)));
        chineseRest.addMenu(chineseMenu);

        //SouthIndianRestaurant
        RestaurantOwner owner2 = new RestaurantOwner("Owner2");
        Restaurant southIndianRest = new Restaurant("South Indian Food", owner2, new Location(2, 3));
        Dish idli = new Dish("idli", CUISINE.SOUTH_INDIAN, 200);
        Dish dosa = new Dish("dosa", CUISINE.SOUTH_INDIAN, 180);
        Dish uttapam = new Dish("uttapam", CUISINE.SOUTH_INDIAN, 120);
        Menu southIndianMenu = new Menu(new ArrayList<>(Arrays.asList(noodles, friedRice, springRolls)));
        southIndianRest.addMenu(southIndianMenu);

        //Note that restaurant owners can exist without restaurants, we have used aggregation relationship
        // This can lead to owners being present with no restaurants adn this not added in restaurant managers
        // This is how we have designed and we should know consequences of the way we have structured.

        RestaurantMgr restaurantMgr = RestaurantMgr.getRestaurantMgr();
        restaurantMgr.addRestaurant("Chini", chineseRest);
        restaurantMgr.addRestaurant("South Indian Restaurant", southIndianRest);


        DeliveryPartner x = new DeliveryPartner("x");
        DeliveryPartner y = new DeliveryPartner("y");
        DeliveryPartner z = new DeliveryPartner("z");

        DeliveryPartnerMgr deliveryPartnerMgr = DeliveryPartnerMgr.getDeliveryPartnerMgr();
        deliveryPartnerMgr.addDeliveryPartner("x", x);
        deliveryPartnerMgr.addDeliveryPartner("y", y);
        deliveryPartnerMgr.addDeliveryPartner("z", z);


        User a = new User("a", new Location(5, 5));
        User b = new User("b", new Location(4, 2));
        User c = new User("c", new Location(6, 4));
        //Users can exist without userManager as well. That's why it is an aggregation relationship

        UserMgr userMgr = UserMgr.getUserMgr();
        userMgr.addUser("a", a);
        userMgr.addUser("b", b);
        userMgr.addUser("c", c);


        // I am passing same dish object that was created by restaurant

        HashMap<Dish, Integer> cart = new HashMap<>();
        cart.put(noodles, 2);
        cart.put(friedRice, 1);
        Order order1 = new Order(a, chineseRest, cart);

        OrderMgr orderMgr = OrderMgr.getOrderMgr();
        orderMgr.createOrder("order1", order1);
        // Ideally the id should be created in order manager when order is created
        // This is just for simplicity purposes and has been mentioned in the class as well
        // We have done same for all ids - user, restaurant, delivery partner, etc.

    }
}
package org.example.delivery;

import org.example.utils.Location;

public class DeliveryMetaData {
    private Location userLoc;
    private Location restLoc;
    private String orderId;
    // weather conditions


    public DeliveryMetaData(String orderId, Location restLoc, Location userLoc) {
        this.orderId = orderId;
        this.restLoc = restLoc;
        this.userLoc = userLoc;
    }

    public Location getUserLoc() {
        return userLoc;
    }

    public Location getRestLoc() {
        return restLoc;
    }

    public String getOrderId() {
        return orderId;
    }
}

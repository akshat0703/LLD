package org.example.delivery;

import org.example.IPartner;
import org.example.notifications.NotificationMgr;

public class DeliveryPartner extends IPartner {

    public DeliveryPartner(String name) {
        super(name);
    }

    public void performDelivery(String orderId, DeliveryMetaData deliveryMetaData) {
        NotificationMgr notificationMgr = NotificationMgr.getNotificationMgr();

        double restaurantLatitude = deliveryMetaData.getRestLoc().getLatitude();
        double restaurantLongitude = deliveryMetaData.getRestLoc().getLongitude();

        notificationMgr.notify(orderId, name + " going to pick up delivery from location " + restaurantLatitude + ", " + restaurantLongitude);

        try {
            Thread.sleep(5000);

            double userLocLatitude = deliveryMetaData.getUserLoc().getLatitude();
            double userLocLongitude = deliveryMetaData.getUserLoc().getLongitude();

            notificationMgr.notify(orderId, name + " reached the location " + userLocLatitude + ", " + userLocLongitude);

            Thread.sleep(5000);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        notificationMgr.notify(orderId, name + " delivered the order. Congratulations!");
    }



}

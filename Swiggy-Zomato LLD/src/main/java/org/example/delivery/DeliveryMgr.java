package org.example.delivery;

import org.example.StrategyMgr;
import org.example.notifications.NotificationMgr;
import org.example.notifications.PushNotificationSender;

import java.util.List;

public class DeliveryMgr {
    private DeliveryMgr() {

    }

    private static DeliveryMgr deliveryMgrInstance;

    public static DeliveryMgr getDeliveryMgr() {
        if(deliveryMgrInstance == null) {
            deliveryMgrInstance = new DeliveryMgr();
        }
        return deliveryMgrInstance;
    }

    // This function should be broken down into sub parts and every method should have one small responsibility
    public void manageDelivery(String orderId, DeliveryMetaData deliveryMetaData) {
        StrategyMgr strategyMgr = StrategyMgr.getStrategyMgr();

        LocBasedDeliveryChargeCalculationStrategy.IDeliveryPartnerMatchingStrategy deliveryPartnerMatchingStrategy =
                strategyMgr.determineDeliveryPartnerMatchingStrategy(deliveryMetaData);

        List<DeliveryPartner> deliveryPartners = deliveryPartnerMatchingStrategy.matchDeliveryPartners(deliveryMetaData);

        NotificationMgr notificationMgr = NotificationMgr.getNotificationMgr();
        // Send push notifications to the nearest delivery partners

        for (DeliveryPartner deliveryPartner : deliveryPartners) {
            notificationMgr.notifyParticularUser(deliveryPartner.getName(), "Delivery Request", new PushNotificationSender());
        }

        DeliveryPartner assignedDeliveryPartner = deliveryPartners.get(0);

        // Assume first delivery partner accepted it
        notificationMgr.notify(orderId, "Delivery Partner" + assignedDeliveryPartner.getName() + " is assigned.");

        assignedDeliveryPartner.performDelivery(orderId, deliveryMetaData);
    }
}

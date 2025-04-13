package org.example.delivery;

import java.util.ArrayList;
import java.util.List;

public class LocBasedDeliveryPartnerMatchingStrategy implements LocBasedDeliveryChargeCalculationStrategy.IDeliveryPartnerMatchingStrategy {

    public List<DeliveryPartner> matchDeliveryPartners(DeliveryMetaData deliveryMetaData) {
        DeliveryPartnerMgr deliveryPartnerMgr = DeliveryPartnerMgr.getDeliveryPartnerMgr();
        System.out.println("Quadtrees can be used yto get nearest delivery partners.\n Delivery partner manager can be used" +
                "to get details of partners.\n Returning all delivery partners for demo purposes for now.");

        List<DeliveryPartner> nearestDeliveryPartners = new ArrayList<>();
        deliveryPartnerMgr.getDeliveryPartnersMap()
                .forEach((name, deliveryPartner) -> nearestDeliveryPartners.add(deliveryPartner));

        return nearestDeliveryPartners;
    }
}

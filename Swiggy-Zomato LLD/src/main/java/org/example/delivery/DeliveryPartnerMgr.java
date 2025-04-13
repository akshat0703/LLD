package org.example.delivery;

import java.util.HashMap;

public class DeliveryPartnerMgr {
    private DeliveryPartnerMgr() {
        deliveryPartnerMap = new HashMap<>();
    }

    private static DeliveryPartnerMgr deliveryPartnerMgrInstance;
    private final HashMap<String, DeliveryPartner> deliveryPartnerMap;

    public static DeliveryPartnerMgr getDeliveryPartnerMgr() {
        if(deliveryPartnerMgrInstance == null) {
            deliveryPartnerMgrInstance = new DeliveryPartnerMgr();
        }
        return deliveryPartnerMgrInstance;
    }

    public void addDeliveryPartner(String deliveryPartnerName, DeliveryPartner deliveryPartner) {
        deliveryPartnerMap.put(deliveryPartnerName, deliveryPartner);
    }

    public DeliveryPartner getDeliveryPartner(String deliveryPartnerName) {
        return deliveryPartnerMap.get(deliveryPartnerName);
    }

    public HashMap<String, DeliveryPartner> getDeliveryPartnersMap() {
        return deliveryPartnerMap;
    }
}

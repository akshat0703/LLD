package org.example.delivery;

import java.util.List;

public class LocBasedDeliveryChargeCalculationStrategy implements DeliveryChargeCalculationStrategy {

    @Override
    public double calculateDeliveryCharge(DeliveryMetaData deliveryMetaData) {
        System.out.println("Delivery charge is calculated based on location. Setting to 20 as default value for now.");
        return 20.0;
    }

    public static interface IDeliveryPartnerMatchingStrategy {
        List<DeliveryPartner> matchDeliveryPartners(DeliveryMetaData deliveryMetaData);
    }
}

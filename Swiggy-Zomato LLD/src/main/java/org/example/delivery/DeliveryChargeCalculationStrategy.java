package org.example.delivery;

public interface DeliveryChargeCalculationStrategy {
    double calculateDeliveryCharge(DeliveryMetaData deliveryMetaData);
}

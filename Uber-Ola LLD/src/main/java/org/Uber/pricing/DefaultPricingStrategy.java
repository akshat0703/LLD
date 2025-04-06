package org.Uber.pricing;

import org.Uber.TripMetaData;

public class DefaultPricingStrategy implements PricingStrategy {

    @Override
    public double calculatePrice(TripMetaData tripMetaData) {
        System.out.println("Based on default strategy, price is 100");
        return 100.0;
    }
}

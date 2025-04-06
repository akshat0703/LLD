package org.Uber.pricing;

import org.Uber.TripMetaData;

public interface PricingStrategy {

    double calculatePrice(TripMetaData tripMetaData);
}

package org.Uber.pricing;

import org.Uber.utils.RatingEnum;
import org.Uber.TripMetaData;

public class RatingBasedPricingStrategy implements PricingStrategy {

    @Override
    public double calculatePrice(TripMetaData tripMetaData) {
        double price = isHighRating(tripMetaData.getRiderRating()) ? 55.0 : 65.0;
        System.out.println("Based on " + tripMetaData.getRiderRating() + " rider rating, price of the trip is " + price);
        return price;
    }

    private boolean isHighRating(RatingEnum rating) {
        return rating == RatingEnum.FOUR_STAR || rating == RatingEnum.FIVE_STAR;
    }
}

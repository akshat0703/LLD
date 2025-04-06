package org.Uber;

import org.Uber.driver.DriverMatchingStrategy;
import org.Uber.driver.LeastTimeBasedMatchingStrategy;
import org.Uber.pricing.PricingStrategy;
import org.Uber.pricing.RatingBasedPricingStrategy;

public class StrategyMgr {
    private static StrategyMgr strategyMgr;

    private StrategyMgr() {
        //
    }

    public static StrategyMgr getStrategyMgr() {
        if(strategyMgr == null) {
            strategyMgr = new StrategyMgr();
        }
        return strategyMgr;
    }

    PricingStrategy determinePricingStrategy(TripMetaData tripMetaData) {
        System.out.println("Based on location and other factors, setting pricing strategy");
        return new RatingBasedPricingStrategy();
    }

    DriverMatchingStrategy determineMatchingStrategy(TripMetaData tripMetaData) {
        System.out.println("Based on location and other factors, setting matching strategy");
        return new LeastTimeBasedMatchingStrategy();
    }
}

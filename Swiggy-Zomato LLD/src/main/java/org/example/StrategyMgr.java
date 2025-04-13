package org.example;

import org.example.delivery.DeliveryMetaData;
import org.example.delivery.LocBasedDeliveryChargeCalculationStrategy;
import org.example.delivery.LocBasedDeliveryPartnerMatchingStrategy;

public class StrategyMgr {
    private StrategyMgr() {

    }
    private static StrategyMgr strategyMgrInstance;

    public static StrategyMgr getStrategyMgr() {
        if(strategyMgrInstance == null) {
            strategyMgrInstance = new StrategyMgr();
        }
        return strategyMgrInstance;
    }

    public LocBasedDeliveryChargeCalculationStrategy.IDeliveryPartnerMatchingStrategy determineDeliveryPartnerMatchingStrategy(DeliveryMetaData deliveryMetaData) {
        System.out.println("Based ob location, weather and other factors, setting partner strategy.");
        return new LocBasedDeliveryPartnerMatchingStrategy();
    }
}

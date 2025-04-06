package org.Uber;

import org.Uber.driver.Driver;
import org.Uber.driver.DriverMatchingStrategy;
import org.Uber.driver.DriverMgr;
import org.Uber.pricing.PricingStrategy;
import org.Uber.rider.Rider;
import org.Uber.rider.RiderMgr;
import org.Uber.utils.Location;

import java.util.HashMap;
import java.util.Map;

public class TripMgr {
    private static TripMgr tripMgr;
    private RiderMgr riderMgr;
    private DriverMgr driverMgr;
    Map<Integer, TripMetaData> tripsMetaDataInfo;
    Map<Integer, Trip> tripsInfo;

    private TripMgr() {
        riderMgr = RiderMgr.getRiderMgr();
        driverMgr = DriverMgr.getDriverMgr();
        tripsInfo = new HashMap<>();
        tripsMetaDataInfo = new HashMap<>();
    }

    public static TripMgr getTripMgr() {
        if(tripMgr == null) {
            tripMgr = new TripMgr();
        }
        return tripMgr;
    }

    public void createTrip(Rider rider, Location srcLoc, Location destLoc) {
        TripMetaData tripMetaData = new TripMetaData(srcLoc, destLoc, rider.getRating());
        StrategyMgr strategyMgr = StrategyMgr.getStrategyMgr();
        PricingStrategy pricingStrategy = strategyMgr.determinePricingStrategy(tripMetaData);
        DriverMatchingStrategy driverMatchingStrategy = strategyMgr.determineMatchingStrategy(tripMetaData);

        Driver driver = driverMatchingStrategy.matchDriver(tripMetaData);
        double price = pricingStrategy.calculatePrice(tripMetaData);

        Trip trip = new Trip(driver, rider, srcLoc, destLoc, price, pricingStrategy, driverMatchingStrategy);
        int tripId = trip.getTripId();
        tripsInfo.put(tripId, trip);
        tripsMetaDataInfo.put(tripId, tripMetaData);
    }

    public Map<Integer, Trip> getTripsMap() {
        return tripsInfo;
    }
}

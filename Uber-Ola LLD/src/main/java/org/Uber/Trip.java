package org.Uber;

import org.Uber.driver.Driver;
import org.Uber.driver.DriverMatchingStrategy;
import org.Uber.pricing.PricingStrategy;
import org.Uber.rider.Rider;
import org.Uber.utils.Location;
import org.Uber.utils.TripStatus;

public class Trip {
    private Driver driver;
    private Rider rider;
    private Location srcLoc;
    private Location destLoc;
    private TripStatus tripStatus;
    private int tripId;
    private double price;
    private PricingStrategy pricingStrategy;
    private DriverMatchingStrategy driverMatchingStrategy;
    private static int nextTripId = 1;

    public Trip(Driver driver, Rider rider, Location srcLoc, Location destLoc, double price,
                PricingStrategy pricingStrategy, DriverMatchingStrategy driverMatchingStrategy) {
        this.driver = driver;
        this.rider = rider;
        this.srcLoc = srcLoc;
        this.destLoc = destLoc;
        this.price = price;
        this.pricingStrategy = pricingStrategy;
        this.driverMatchingStrategy = driverMatchingStrategy;

        this.tripStatus = TripStatus.DRIVER_ON_THE_WAY;
        this.tripId = Trip.nextTripId;
        nextTripId += 1;
    }

    public int getTripId() {
        return tripId;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "driver=" + driver +
                ", rider=" + rider +
                ", srcLoc=" + srcLoc +
                ", destLoc=" + destLoc +
                ", tripStatus=" + tripStatus +
                ", tripId=" + tripId +
                ", price=" + price +
                ", pricingStrategy=" + pricingStrategy +
                ", driverMatchingStrategy=" + driverMatchingStrategy +
                '}';
    }
}

package org.Uber;

import org.Uber.driver.Driver;
import org.Uber.driver.DriverMgr;
import org.Uber.rider.Rider;
import org.Uber.rider.RiderMgr;
import org.Uber.utils.Location;
import org.Uber.utils.RatingEnum;

import java.util.Map;

public class Uber {
    public static void main(String[] args) {
        Rider rider1 = new Rider("ABC", RatingEnum.THREE_STAR);
        Rider rider2 = new Rider("DEF", RatingEnum.FIVE_STAR);
        RiderMgr riderMgr = RiderMgr.getRiderMgr();
        riderMgr.addRider("ABC", rider1);
        riderMgr.addRider("DEF", rider2);

        Driver driver1 = new Driver("XYZ", RatingEnum.FOUR_STAR);
        Driver driver2 = new Driver("UVW", RatingEnum.TWO_STAR);
        DriverMgr driverMgr = DriverMgr.getDriverMgr();
        driverMgr.addDriver("XYZ", driver1);
        driverMgr.addDriver("UVW", driver2);

        TripMgr tripMgr = TripMgr.getTripMgr();

        System.out.println("Creating trip for rider1 from Location(10, 10) to Location(20, 20)");
        tripMgr.createTrip(rider1, new Location(10, 10), new Location(20, 20));

        System.out.println("Creating trip for rider2 from Location(70, 50) to Location(80, 60)");
        tripMgr.createTrip(rider2, new Location(70, 50), new Location(80, 60));

        // Display all created Trips
        Map<Integer, Trip> tripsMap = tripMgr.getTripsMap();
        tripsMap.forEach((tripId, trip) -> {
            System.out.println(trip.toString());
        });
    }
}
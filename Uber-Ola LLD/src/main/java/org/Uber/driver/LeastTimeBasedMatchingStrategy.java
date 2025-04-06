package org.Uber.driver;

import org.Uber.TripMetaData;

public class LeastTimeBasedMatchingStrategy implements DriverMatchingStrategy {

    @Override
    public Driver matchDriver(TripMetaData tripMetaData) {
        DriverMgr driverMgr = DriverMgr.getDriverMgr();

        if(driverMgr.getDriversMap().isEmpty()) {
            System.out.println("No drivers found!!!");
        }

        //Quadtree can be used to decide the nearest driver
        Driver driver = driverMgr.getDriversMap().entrySet().iterator().next().getValue();
        System.out.println("Setting " + driver.getDriverName() + " as driver");
        tripMetaData.setDriverRating(driver.getRating());
        return driver;
    }
}

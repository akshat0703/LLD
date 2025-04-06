package org.Uber.driver;

import java.util.HashMap;
import java.util.Map;

public class DriverMgr {
    private static DriverMgr driverMgr;
    private Map<String, Driver> driversMap;

    private DriverMgr() {
        driversMap = new HashMap<>();
    }
    public static DriverMgr getDriverMgr() {
        if(driverMgr == null) {
            driverMgr = new DriverMgr();
        }
        return driverMgr;
    }

    public void addDriver(String driverName, Driver driver) {
        driversMap.put(driverName, driver);
    }

    public Driver getDriver(String driverName) {
        return driversMap.get(driverName);
    }

    public Map<String, Driver> getDriversMap() {
        return driversMap;
    }
}

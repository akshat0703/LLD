package org.Uber.rider;

import java.util.HashMap;

public class RiderMgr {
    private static RiderMgr riderMgr;
    private HashMap<String, Rider> ridersMap;

    private RiderMgr() {
        ridersMap = new HashMap<>();
    }
    public static RiderMgr getRiderMgr() {
        if(riderMgr == null) {
            riderMgr = new RiderMgr();
        }
        return riderMgr;
    }

    public void addRider(String riderName, Rider rider) {
        ridersMap.put(riderName, rider);
    }

    public Rider getRider(String riderName) {
        return ridersMap.get(riderName);
    }
}

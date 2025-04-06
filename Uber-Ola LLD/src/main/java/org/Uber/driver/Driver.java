package org.Uber.driver;

import org.Uber.utils.RatingEnum;

public class Driver {
    private String driverName;
    private boolean available;
    private RatingEnum rating;

    public Driver(String driverName, RatingEnum rating) {
        this.driverName = driverName;
        this.rating = rating;
        available = false;
    }

    public RatingEnum getRating() {
        return rating;
    }

    public boolean isAvailable() {
        return available;
    }

    public void updateAvailable(boolean available) {
        this.available = available;
    }

    public String getDriverName() {
        return driverName;
    }
}

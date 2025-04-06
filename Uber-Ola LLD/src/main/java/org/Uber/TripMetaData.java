package org.Uber;

import org.Uber.utils.Location;
import org.Uber.utils.RatingEnum;

public class TripMetaData {
    private Location srcLoc;
    private Location destLoc;
    private RatingEnum riderRating;
    private RatingEnum driverRating;

    public TripMetaData(Location srcLoc, Location destLoc, RatingEnum riderRating) {
        this.srcLoc = srcLoc;
        this.destLoc = destLoc;
        this.riderRating = riderRating;
        this.driverRating = RatingEnum.UNASSIGNED;
    }

    //getters and setters

    public Location getSrcLoc() {
        return srcLoc;
    }

    public void setSrcLoc(Location srcLoc) {
        this.srcLoc = srcLoc;
    }

    public Location getDestLoc() {
        return destLoc;
    }

    public void setDestLoc(Location destLoc) {
        this.destLoc = destLoc;
    }

    public RatingEnum getRiderRating() {
        return riderRating;
    }

    public void setRiderRating(RatingEnum riderRating) {
        this.riderRating = riderRating;
    }

    public RatingEnum getDriverRating() {
        return driverRating;
    }

    public void setDriverRating(RatingEnum driverRating) {
        this.driverRating = driverRating;
    }
}

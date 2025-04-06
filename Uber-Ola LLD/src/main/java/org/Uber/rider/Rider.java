package org.Uber.rider;

import org.Uber.utils.RatingEnum;

public class Rider {
    private String riderName;
    private RatingEnum rating;

    public Rider(String riderName, RatingEnum rating) {
        this.riderName = riderName;
        this.rating = rating;
    }

    public String getRiderName() {
        return riderName;
    }

    public RatingEnum getRating() {
        return rating;
    }
}

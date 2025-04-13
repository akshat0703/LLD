package org.example;

import org.example.utils.RATING;

public class IPartner {
    public String name;
    public RATING rating;
    // kyc details


    public IPartner(String name) {
        this.name = name;
        rating = RATING.UNASSIGNED;
    }

    public String getName() {
        return name;
    }

    public RATING getRating() {
        return rating;
    }

}

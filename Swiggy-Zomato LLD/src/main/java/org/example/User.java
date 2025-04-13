package org.example;

import org.example.utils.Location;

public class User {
    private String name;
    private Location location;

    public User(String name, Location location) {
        this.name = name;
        this.location = location;
    }

    public String getId() {
        return name;
    }

    public Location getLocation() {
        return location;
    }
}

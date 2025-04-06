package org.Uber.driver;

import org.Uber.TripMetaData;

public interface DriverMatchingStrategy {
    Driver matchDriver(TripMetaData tripMetaData);
}

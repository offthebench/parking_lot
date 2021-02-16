package com.gojek.executor;

import com.gojek.exception.ParkingLotException;

public interface ParkingServiceExecutor {

    default void execute() {
        throw new ParkingLotException("NOT_IMPLEMENTED");
    }
}

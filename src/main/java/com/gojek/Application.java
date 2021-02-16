package com.gojek;

import com.gojek.executor.ParkingExecutorFactory;

public class Application {

    public static void main(String[] args) {
        ParkingExecutorFactory.getInstance().getExecutor(args).execute();
    }
}
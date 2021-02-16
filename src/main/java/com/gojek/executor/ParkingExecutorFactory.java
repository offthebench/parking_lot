package com.gojek.executor;

public class ParkingExecutorFactory {

    private static ParkingExecutorFactory instance;

    private ParkingExecutorFactory() {
    }

    public static ParkingExecutorFactory getInstance() {
        if (null == instance) {
            instance = new ParkingExecutorFactory();
        }
        return instance;
    }

    public ParkingServiceExecutor getExecutor(String[] args) {
        if (null != args && args.length > 0) {
            return new FileExecutor(args[0]);
        }
        return new CommandLineExecutor();
    }
}

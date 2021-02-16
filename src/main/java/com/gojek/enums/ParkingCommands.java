package com.gojek.enums;

import com.gojek.exception.ParkingLotException;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum  ParkingCommands {
    CREATE_PARKING_LOT("create_parking_lot"),
    PARK_VEHICLE("park"),
    UN_PARK_VEHICLE("leave"),
    STATUS("status"),
    VEHICLES_BY_COLOR("registration_numbers_for_cars_with_colour"),
    SLOTS_BY_VEHICLES_COLOR("slot_numbers_for_cars_with_colour"),
    SLOTS_BY_VEHICLE_NUMBER("slot_number_for_registration_number");

    private static Map<String, ParkingCommands> parkingCommandMap = Collections.unmodifiableMap(initializeMapping());

    private String command;

    ParkingCommands(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    public static ParkingCommands mapToCommand(String inputCommand) {
        ParkingCommands command = parkingCommandMap.get(inputCommand);
        if (null == command) {
            throw new ParkingLotException("INVALID_INPUT_COMMAND");
        }
        return command;
    }

    private static Map<String, ParkingCommands> initializeMapping() {
        Map<String, ParkingCommands> errorMappingMap = new HashMap<>();
        for (ParkingCommands command : ParkingCommands.values()) {
            errorMappingMap.put(command.getCommand(), command);
        }
        return errorMappingMap;
    }
}

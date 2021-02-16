package com.gojek.command;

import com.gojek.enums.ParkingCommands;

import java.util.EnumMap;
import java.util.Map;

public class ParkingCommandManager {

    private static Map<ParkingCommands, Command> commandMap = new EnumMap<>(ParkingCommands.class);
    private static ParkingCommandManager instance;

    private ParkingCommandManager() {
        commandMap.put(ParkingCommands.CREATE_PARKING_LOT, new CreateParkingLotCommand());
        commandMap.put(ParkingCommands.PARK_VEHICLE, new ParkVehicleCommand());
        commandMap.put(ParkingCommands.STATUS, new ParkingStatusCommand());
        commandMap.put(ParkingCommands.UN_PARK_VEHICLE, new UnParkVehicleCommand());
        commandMap.put(ParkingCommands.VEHICLES_BY_COLOR, new RegistrationInfoByColorCommand());
        commandMap.put(ParkingCommands.SLOTS_BY_VEHICLE_NUMBER, new SlotNumberByVehicleRegistrationCommand());
        commandMap.put(ParkingCommands.SLOTS_BY_VEHICLES_COLOR, new SlotNumbersByColorCommand());
    }

    public static ParkingCommandManager getInstance() {
        if (instance == null) {
            instance = new ParkingCommandManager();
        }

        return instance;
    }

    public Command getCommand(String inputCommand) {
        return commandMap.get(ParkingCommands.mapToCommand(inputCommand));
    }
}

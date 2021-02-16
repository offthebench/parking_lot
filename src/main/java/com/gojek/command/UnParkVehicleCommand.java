package com.gojek.command;

import com.gojek.constants.Constants;
import com.gojek.entity.Slot;
import com.gojek.exception.ParkingLotException;
import com.gojek.strategy.ParkingManager;
import com.gojek.writer.Writer;
import com.gojek.writer.WriterFactory;

import static com.gojek.constants.Constants.UN_PARK_VEHICLE_MESSAGE;
import static com.gojek.writer.WriterType.CONSOLE;

public class UnParkVehicleCommand implements Command {

    @Override
    public void execute(String[] args) {
        if (null == args || args.length != 2) {
            throw new ParkingLotException(Constants.INVALID_INPUT_COMMAND);
        }

        long inputSlotNumber = Long.parseLong(args[1]);
        ParkingManager parkingManager = ParkingManager.getInstance();
        Writer writer = WriterFactory.getInstance().getWriter(CONSOLE);
        try {
            Slot slot = parkingManager.unPark(inputSlotNumber);
            writer.write(String.format(UN_PARK_VEHICLE_MESSAGE, slot.getSlotNumber()));
        } catch (ParkingLotException ex) {
            writer.write(ex.getMessage());
        }
    }
}

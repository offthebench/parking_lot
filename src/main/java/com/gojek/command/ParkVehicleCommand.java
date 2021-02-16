package com.gojek.command;

import com.gojek.constants.Constants;
import com.gojek.entity.Car;
import com.gojek.entity.Slot;
import com.gojek.entity.Vehicle;
import com.gojek.exception.ParkingLotException;
import com.gojek.strategy.ParkingManager;
import com.gojek.writer.Writer;
import com.gojek.writer.WriterFactory;

import static com.gojek.constants.Constants.PARK_VEHICLE_MESSAGE;
import static com.gojek.writer.WriterType.CONSOLE;

public class ParkVehicleCommand implements Command {

    @Override
    public void execute(String[] args) {
        if (null == args || args.length != 3) {
            throw new ParkingLotException(Constants.INVALID_INPUT_COMMAND);
        }

        Vehicle vehicle = initialiseVehicle(args);
        ParkingManager parkingManager = ParkingManager.getInstance();
        Writer writer = WriterFactory.getInstance().getWriter(CONSOLE);

        try {
            Slot slot = parkingManager.park(vehicle);
            writer.write(String.format(PARK_VEHICLE_MESSAGE, slot.getSlotNumber()));
        } catch (ParkingLotException ex) {
            writer.write(ex.getMessage());
        }
    }

    private Vehicle initialiseVehicle(String[] args) {
        Vehicle vehicle = new Car();
        vehicle.setRegistrationNumber(args[1]);
        vehicle.setColor(args[2]);

        return vehicle;
    }
}

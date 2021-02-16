package com.gojek.command;

import com.gojek.constants.Constants;
import com.gojek.entity.Slot;
import com.gojek.entity.Vehicle;
import com.gojek.exception.ParkingLotException;
import com.gojek.strategy.ParkingManager;
import com.gojek.writer.Writer;
import com.gojek.writer.WriterFactory;

import java.util.List;
import java.util.stream.Collectors;

import static com.gojek.writer.WriterType.CONSOLE;

public class SlotNumberByVehicleRegistrationCommand implements Command {

    @Override
    public void execute(String[] args) {
        if (null == args || args.length != 2) {
            throw new ParkingLotException(Constants.INVALID_INPUT_COMMAND);
        }

        String inputRegistrationNumber = args[1];
        ParkingManager parkingManager = ParkingManager.getInstance();
        Writer writer = WriterFactory.getInstance().getWriter(CONSOLE);

        try {
            Slot parkingSlotByRegistrationNumber = parkingManager.getParkingSlotByRegistrationNumber(inputRegistrationNumber);
            writer.write(String.valueOf(parkingSlotByRegistrationNumber.getSlotNumber()));
        } catch (ParkingLotException ex) {
            writer.write(ex.getMessage());
        }
    }
}

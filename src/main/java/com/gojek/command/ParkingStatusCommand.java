package com.gojek.command;

import com.gojek.constants.Constants;
import com.gojek.entity.Slot;
import com.gojek.exception.ParkingLotException;
import com.gojek.strategy.ParkingManager;
import com.gojek.writer.Writer;
import com.gojek.writer.WriterFactory;

import java.util.List;

import static com.gojek.constants.Constants.PARKING_STATUS_HEADER;
import static com.gojek.constants.Constants.PARKING_STATUS_RESULT_MESSAGE;
import static com.gojek.writer.WriterType.CONSOLE;

public class ParkingStatusCommand implements Command {

    @Override
    public void execute(String[] args) {
        if (null == args) {
            throw new ParkingLotException(Constants.INVALID_INPUT_COMMAND);
        }

        ParkingManager parkingManager = ParkingManager.getInstance();
        Writer writer = WriterFactory.getInstance().getWriter(CONSOLE);

        try {
            List<Slot> parkingStatus = parkingManager.status();
            writer.write(PARKING_STATUS_HEADER);
            parkingStatus.forEach( parking -> writer.write(String.format(PARKING_STATUS_RESULT_MESSAGE,
                    parking.getSlotNumber(), parking.getVehicle().getRegistrationNumber(), parking.getVehicle().getColor())));
        } catch (ParkingLotException ex) {
            writer.write(ex.getMessage());
        }

    }
}

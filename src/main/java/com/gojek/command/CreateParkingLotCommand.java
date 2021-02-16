package com.gojek.command;

import com.gojek.exception.ParkingLotException;
import com.gojek.strategy.ParkingManager;
import com.gojek.writer.Writer;
import com.gojek.writer.WriterFactory;

import static com.gojek.constants.Constants.CREATED_A_PARKING_LOT_WITH_S_SLOTS;
import static com.gojek.constants.Constants.INVALID_INPUT_COMMAND;
import static com.gojek.writer.WriterType.CONSOLE;

public class CreateParkingLotCommand implements Command {

    @Override
    public void execute(String[] args) {
        if (null == args || args.length == 0) {
            throw new ParkingLotException(INVALID_INPUT_COMMAND);
        }

        Long size = Long.valueOf(args[1]);
        ParkingManager manager = ParkingManager.getInstance();
        Writer writer = WriterFactory.getInstance().getWriter(CONSOLE);

        try {
            int parkingSlots = manager.createParingSlots(size);
            writer.write(String.format(CREATED_A_PARKING_LOT_WITH_S_SLOTS, parkingSlots));
        } catch (ParkingLotException ex) {
            writer.write(ex.getMessage());
        }
    }
}

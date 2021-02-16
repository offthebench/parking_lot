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

public class SlotNumbersByColorCommand implements Command {

    @Override
    public void execute(String[] args) {
        if (null == args || args.length != 2) {
            throw new ParkingLotException(Constants.INVALID_INPUT_COMMAND);
        }

        String slots = "";
        String inputColor = args[1];
        ParkingManager parkingManager = ParkingManager.getInstance();
        Writer writer = WriterFactory.getInstance().getWriter(CONSOLE);

        try {
            List<Slot> allSlotsByColor = parkingManager.getReservedSlotsByVehicleColor(inputColor);
            if (allSlotsByColor.size() != 0) {
                List<Long> slotNumbers = allSlotsByColor.stream().map(Slot::getSlotNumber).collect(Collectors.toList());
                slots = slotNumbers.toString().substring(1, slotNumbers.toString().length() - 1);
            }
            writer.write(slots);
        } catch (ParkingLotException ex) {
            writer.write(ex.getMessage());
        }
    }
}

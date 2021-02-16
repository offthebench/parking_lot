package com.gojek.command;

import com.gojek.constants.Constants;
import com.gojek.entity.Vehicle;
import com.gojek.exception.ParkingLotException;
import com.gojek.strategy.ParkingManager;
import com.gojek.writer.Writer;
import com.gojek.writer.WriterFactory;

import java.util.List;
import java.util.stream.Collectors;

import static com.gojek.writer.WriterType.CONSOLE;

public class RegistrationInfoByColorCommand implements Command {

    @Override
    public void execute(String[] args) {
        if (null == args || args.length != 2) {
            throw new ParkingLotException(Constants.INVALID_INPUT_COMMAND);
        }

        String registrationNumbers = "";
        String inputColor = args[1];
        ParkingManager parkingManager = ParkingManager.getInstance();
        Writer writer = WriterFactory.getInstance().getWriter(CONSOLE);

        try {
            List<Vehicle> allVehiclesByColor = parkingManager.getAllVehiclesByColor(inputColor);
            if (allVehiclesByColor.size() != 0) {
                List<String> registrationNumberList = allVehiclesByColor.stream().map(Vehicle::getRegistrationNumber).collect(Collectors.toList());
                registrationNumbers = registrationNumberList.toString().substring(1, registrationNumberList.toString().length() - 1);
            }
            writer.write(registrationNumbers);
        } catch (ParkingLotException ex) {
            writer.write(ex.getMessage());
        }
    }
}

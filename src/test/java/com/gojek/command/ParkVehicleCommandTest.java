package com.gojek.command;

import com.gojek.exception.ParkingLotException;
import org.junit.Before;
import org.junit.Test;

public class ParkVehicleCommandTest {

    private Command command = null;

    @Before
    public void setupInstance() {
        command = new ParkVehicleCommand();
    }

    @Test(expected = ParkingLotException.class)
    public void testParkVehicleThrowException() {
        command.execute(null);
    }

    @Test(expected = ParkingLotException.class)
    public void testParkVehicleWithLessArgumentsThrowException() {
        command.execute(new String[]{"park", "KA-03-JJ-7056"});
    }

    @Test
    public void testParkVehicle() {
        command.execute(new String[]{"park", "KA-03-JJ-7056", "Black"});
    }

}

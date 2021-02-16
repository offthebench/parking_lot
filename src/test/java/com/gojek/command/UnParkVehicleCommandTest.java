package com.gojek.command;

import com.gojek.exception.ParkingLotException;
import org.junit.Before;
import org.junit.Test;

public class UnParkVehicleCommandTest {

    private Command command = null;

    @Before
    public void setupInstance() {
        command = new UnParkVehicleCommand();
    }

    @Test(expected = ParkingLotException.class)
    public void testUnParkVehicleThrowException() {
        command.execute(null);
    }

    @Test(expected = ParkingLotException.class)
    public void testUnParkVehicleWithLessArgumentsThrowException() {
        command.execute(new String[]{"leave", "1", "2"});
    }

    @Test
    public void testUnParkVehicleThrowsException() {
        command.execute(new String[]{"leave", "1"});
    }

}

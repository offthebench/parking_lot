package com.gojek.command;

import com.gojek.exception.ParkingLotException;
import org.junit.Before;
import org.junit.Test;

public class CreateParkingLotCommandTest {

    private Command command = null;

    @Before
    public void setupInstance() {
        command = new CreateParkingLotCommand();
    }

    @Test(expected = ParkingLotException.class)
    public void testCreateThrowException() {
        command.execute(null);
    }

    @Test
    public void testCreateParkingLot() {
        command.execute(new String[]{"create_parking_lot", "6"});
    }

}

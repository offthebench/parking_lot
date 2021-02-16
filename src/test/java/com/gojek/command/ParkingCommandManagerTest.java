package com.gojek.command;

import com.gojek.exception.ParkingLotException;
import org.junit.Assert;
import org.junit.Test;

public class ParkingCommandManagerTest {

    @Test
    public void testInstance() {
        ParkingCommandManager instance1 = ParkingCommandManager.getInstance();
        ParkingCommandManager instance2 = ParkingCommandManager.getInstance();
        Assert.assertNotNull(instance1);
        Assert.assertNotNull(instance2);
        Assert.assertEquals(instance1, instance2);
    }

    @Test(expected = ParkingLotException.class)
    public void getParkingExceptionOnNull() {
        ParkingCommandManager.getInstance().getCommand(null);
    }

    @Test(expected = ParkingLotException.class)
    public void getParkingExceptionOnEmpty() {
        ParkingCommandManager.getInstance().getCommand("");
    }
}

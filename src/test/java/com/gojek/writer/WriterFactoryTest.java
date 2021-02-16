package com.gojek.writer;

import org.junit.Assert;
import org.junit.Test;

public class WriterFactoryTest {

    @Test
    public void testInstance() {
        WriterFactory instance1 = WriterFactory.getInstance();
        WriterFactory instance2 = WriterFactory.getInstance();
        Assert.assertNotNull(instance1);
        Assert.assertNotNull(instance2);
        Assert.assertEquals(instance1, instance2);
    }

    @Test
    public void testConsoleWriterNotNull() {
        Writer writer = WriterFactory.getInstance().getWriter(WriterType.CONSOLE);
        Assert.assertNotNull(writer);
    }

    @Test
    public void testConsoleWriterNull() {
        Writer writer = WriterFactory.getInstance().getWriter(null);
        Assert.assertNull(writer);
    }
}

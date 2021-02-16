package com.gojek.writer;

public class WriterFactory {

    private static WriterFactory instance;

    private WriterFactory() {
    }

    public static WriterFactory getInstance() {
        if (null == instance) {
            instance = new WriterFactory();
        }

        return instance;
    }

    public Writer getWriter(WriterType type) {
        if (WriterType.CONSOLE == type) {
            return new ConsoleWriter();
        }
        return null;
    }
}

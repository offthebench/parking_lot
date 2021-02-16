package com.gojek.executor;

import com.gojek.command.ParkingCommandManager;
import com.gojek.constants.Constants;

import java.io.*;

public class FileExecutor implements ParkingServiceExecutor {

    private String path = null;

    public FileExecutor(String path) {
        this.path = path;
    }

    @Override
    public void execute() {
        File file = new File(this.path);
        try (FileReader fileReader = new FileReader(file); BufferedReader bufferedReader = new BufferedReader(fileReader);) {
            String input = bufferedReader.readLine();
            while (null != input) {
                String[] commands = input.split(Constants.SPACE);
                ParkingCommandManager.getInstance().getCommand(commands[0]).execute(commands);
                input = bufferedReader.readLine();
            }
        } catch (IOException e) {
            //catch the exception and do something with it
        }
    }
}

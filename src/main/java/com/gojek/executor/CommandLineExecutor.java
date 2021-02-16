package com.gojek.executor;

import com.gojek.command.ParkingCommandManager;
import com.gojek.exception.ParkingLotException;
import com.gojek.writer.Writer;
import com.gojek.writer.WriterFactory;
import com.gojek.writer.WriterType;

import java.util.Scanner;

import static com.gojek.constants.Constants.EXIT;
import static com.gojek.constants.Constants.SPACE;

public class CommandLineExecutor implements ParkingServiceExecutor {

    @Override
    public void execute() {
        Scanner in = new Scanner(System.in);
        String inputCommand = in.nextLine();
        while (!EXIT.equalsIgnoreCase(inputCommand)) {
            String[] inputCommandDetails = inputCommand.split(SPACE);
            try {
                ParkingCommandManager.getInstance().getCommand(inputCommandDetails[0]).execute(inputCommandDetails);
            } catch (ParkingLotException e) {
                Writer writer = WriterFactory.getInstance().getWriter(WriterType.CONSOLE);
                writer.write(e.getMessage());
            }
            inputCommand = in.nextLine();
        }
        in.close();
    }
}

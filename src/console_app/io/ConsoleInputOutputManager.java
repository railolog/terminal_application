package console_app.io;

import console_app.commands.CommandWrapper;

import java.util.Scanner;

public class ConsoleInputOutputManager implements InputOutputManager{
    Scanner in;

    public ConsoleInputOutputManager(){
        in = new Scanner(System.in);
    }

    @Override
    public CommandWrapper readCommand() {
        String cmd = "";

        while(cmd.length() == 0) {
            cmd = in.nextLine().trim();
        }

        if (cmd.contains(" ")){
            String[] arr = cmd.split(" ", 2);
            return new CommandWrapper(arr[0], arr[1].trim());
        }

        return new CommandWrapper(cmd);
    }
}

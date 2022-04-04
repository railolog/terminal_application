package console_app.io;

import console_app.commands.CommandWrapper;
import console_app.core.City;

public interface InputOutputManager {
    public CommandWrapper readCommand();

    public void println(String line);

    void print(String line);

    void printErr(String e);

    String readLine();

    City readCity();
}

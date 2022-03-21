package console_app.io;

import console_app.commands.CommandWrapper;

public interface InputOutputManager {
    public CommandWrapper readCommand();

    public void println(String line);
}

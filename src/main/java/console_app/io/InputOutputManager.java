package console_app.io;

import console_app.commands.CommandWrapper;
import console_app.core.City;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

public interface InputOutputManager {
    public CommandWrapper readCommand();

    public void println(String line);

    void print(String line);

    void printErr(String e);

    String readLine();

    City readCity();

    void setFileInput(String path);

    void setScanner(File source) throws FileNotFoundException;

    void setScanner(InputStream source);

    void setPreviousScanner();
}

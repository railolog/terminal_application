package console_app;

import console_app.collection.CityCollectionManager;
import console_app.commands.*;
import console_app.io.ConsoleInputOutputManager;
import console_app.io.FileManager;
import console_app.io.InputOutputManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InputOutputManager ioManager = new ConsoleInputOutputManager(new Scanner(System.in));
        CityCollectionManager collectionManager = new CityCollectionManager(ioManager);

        CommandManager commandManager = new CommandManager(ioManager, new FileManager());

        commandManager.addCommand("info", new InfoCommand(collectionManager));
        commandManager.addCommand("add", new AddCommand(collectionManager));
        commandManager.addCommand("show", new ShowCommand(collectionManager));
        commandManager.addCommand("update", new UpdateCommand(collectionManager));

        commandManager.consoleMode();
    }
}

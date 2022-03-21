package console_app;

import console_app.collection.CityCollectionManager;
import console_app.collection.CollectionManager;
import console_app.commands.CommandManager;
import console_app.commands.InfoCommand;
import console_app.core.City;
import console_app.io.ConsoleInputOutputManager;
import console_app.io.FileManager;
import console_app.io.InputOutputManager;

public class Main {
    public static void main(String[] args) {
        InputOutputManager ioManager = new ConsoleInputOutputManager();
        CityCollectionManager collectionManager = new CityCollectionManager(ioManager);

        CommandManager commandManager = new CommandManager(
                    ioManager,
                    new FileManager()
                );
        commandManager.addCommand("info",
                                  new InfoCommand(collectionManager));
        commandManager.consoleMode();
    }
}

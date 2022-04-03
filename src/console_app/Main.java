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

        commandManager.addCommand("add", new AddCommand(collectionManager));
        commandManager.addCommand("add_if_max", new AddIfMaxCommand(collectionManager));
        commandManager.addCommand("clear", new ClearCommand(collectionManager));
        commandManager.addCommand("filter_greater_than_meters_above_sea_level", new FilterGreaterThanSeaLevel(collectionManager));
        commandManager.addCommand("info", new InfoCommand(collectionManager));
        commandManager.addCommand("min_by_creation_date", new MinByCreationDateCommand(collectionManager));
        commandManager.addCommand("remove_by_id", new RemoveByIdCommand(collectionManager));
        commandManager.addCommand("reorder", new ReorderCommand(collectionManager));
        commandManager.addCommand("show", new ShowCommand(collectionManager));
        commandManager.addCommand("shuffle", new ShuffleCommand(collectionManager));
        commandManager.addCommand("update", new UpdateCommand(collectionManager));

        commandManager.consoleMode();
    }
}

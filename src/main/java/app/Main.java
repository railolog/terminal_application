package app;

import com.google.gson.JsonParseException;
import app.collection.CityCollectionManager;
import app.commands.*;
import app.io.ConsoleInputOutputManager;
import app.io.FileManager;
import app.io.InputOutputManager;

import java.io.FileNotFoundException;
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
        commandManager.addCommand("group_counting_by_coordinates", new GroupCountingCommand(collectionManager));
        commandManager.addCommand("info", new InfoCommand(collectionManager));
        commandManager.addCommand("min_by_creation_date", new MinByCreationDateCommand(collectionManager));
        commandManager.addCommand("remove_by_id", new RemoveByIdCommand(collectionManager));
        commandManager.addCommand("reorder", new ReorderCommand(collectionManager));
        commandManager.addCommand("save", new SaveCommand(collectionManager));
        commandManager.addCommand("show", new ShowCommand(collectionManager));
        commandManager.addCommand("shuffle", new ShuffleCommand(collectionManager));
        commandManager.addCommand("update", new UpdateCommand(collectionManager));

        if (args.length > 0){
            String path = args[0].trim();

            try {
                collectionManager.setCollection(new FileManager().load(path));
            }
            catch (FileNotFoundException | NullPointerException | JsonParseException e){
                ioManager.printErr(e.getMessage() + "\nНе удалось загрузить коллекцию\nЗавершение работы");
                return;
            }
            commandManager.work();
        }
        else {
            ioManager.printErr("не передан путь к файлу\nЗавершение работы");
        }
    }
}

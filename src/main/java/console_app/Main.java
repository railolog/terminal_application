package console_app;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import console_app.collection.CityCollectionManager;
import console_app.commands.*;
import console_app.core.City;
import console_app.core.Coordinates;
import console_app.core.Government;
import console_app.core.Human;
import console_app.io.ConsoleInputOutputManager;
import console_app.io.FileManager;
import console_app.io.InputOutputManager;

import java.io.FileNotFoundException;
import java.lang.reflect.Type;
import java.util.ArrayList;
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
        commandManager.addCommand("save", new SaveCommand(collectionManager));
        commandManager.addCommand("show", new ShowCommand(collectionManager));
        commandManager.addCommand("shuffle", new ShuffleCommand(collectionManager));
        commandManager.addCommand("update", new UpdateCommand(collectionManager));

        Gson gson = new Gson();
        System.out.println(8);

        ArrayList<City> json = new ArrayList<>();
        /*try {
            json = new FileManager().load("data.json");
            collectionManager.setCollection(json);
        }
        catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }

        for (City city: json){
            System.out.println(city);
        }*/

        commandManager.consoleMode();
    }
}

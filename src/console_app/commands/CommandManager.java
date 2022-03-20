package console_app.commands;

import console_app.collection.CollectionManager;
import console_app.io.FileManager;
import console_app.io.InputOutputManager;

import java.util.HashMap;

public class CommandManager {
    private boolean isRunning = false;
    private final HashMap<String, Command> commandMap = new HashMap<>();
    CollectionManager collectionManager;
    InputOutputManager ioManager;
    FileManager fileManager;

    public CommandManager(CollectionManager cm, InputOutputManager io, FileManager fm){
        collectionManager = cm;
        ioManager = io;
        fileManager = fm;
    }

    public void consoleMode(){
        isRunning = true;
        while (isRunning){
            CommandWrapper cmdPair = ioManager.readCommand();

        }
    }

    public void addCommand(String commandName, Command command){
        commandMap.put(commandName, command);
    }

    public void execute(String commandName, String arg){
        Command command = commandMap.get(commandName);
        if (command == null){
            throw new IllegalStateException("no such command as: " + commandName);
        }
        command.execute(arg);
    }
}

package console_app.commands;

import console_app.io.FileManager;
import console_app.io.InputOutputManager;

import java.util.HashMap;
import java.util.Map;

public class CommandManager {
    private boolean isRunning = false;
    private final HashMap<String, Command> commandMap = new HashMap<>();
    InputOutputManager ioManager;
    FileManager fileManager;

    public class HelpCommand implements Command{
        @Override
        public void execute(String arg) {
            ioManager.println(getHelp());
        }

        public String toString(){
            return "вывести справку по доступным командам";
        }
    }

    public CommandManager(InputOutputManager io, FileManager fm){
        ioManager = io;
        fileManager = fm;

        addCommand("help", new HelpCommand());
    }

    public void consoleMode(){
        isRunning = true;
        while (isRunning){
            CommandWrapper cmdPair = ioManager.readCommand();
            execute(cmdPair.getCommand(), cmdPair.getArgument());
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

    public String getHelp(){
        StringBuilder helpList = new StringBuilder();

        for(Map.Entry entry: commandMap.entrySet()){
            helpList.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }

        helpList.deleteCharAt(helpList.length() - 1);
        return helpList.toString();
    }
}

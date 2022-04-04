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

    public class ExitCommand implements Command{
        @Override
        public void execute(String arg) {
            isRunning = false;
        }

        @Override
        public String toString() {
            return "завершить программу (без сохранения в файл)";
        }
    }

    public CommandManager(InputOutputManager io, FileManager fm){
        ioManager = io;
        fileManager = fm;

        addCommand("help", new HelpCommand());
        addCommand("exit", new ExitCommand());
    }

    public void consoleMode(){
        isRunning = true;
        while (isRunning){
            CommandWrapper cmdPair = ioManager.readCommand();
            try {
                System.out.println(cmdPair.getCommand() + ";;;" + cmdPair.getArgument());
                execute(cmdPair.getCommand(), cmdPair.getArgument());
            }
            catch (IllegalStateException e){
                ioManager.printErr(e.getMessage() + "\nСписок команд можно получить с помощью команды help");
            }
        }
    }

    public void addCommand(String commandName, Command command){
        commandMap.put(commandName, command);
    }

    public void execute(String commandName, String arg) throws IllegalStateException{
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

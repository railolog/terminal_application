package app.commands;

import app.io.FileManager;
import app.io.InputOutputManager;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Map;

public class CommandManager {
    private boolean isRunning = false;
    private final HashMap<String, Command> commandMap = new HashMap<>();
    private InputOutputManager ioManager;
    private FileManager fileManager;

    public CommandManager(InputOutputManager io, FileManager fm){
        ioManager = io;
        fileManager = fm;

        addCommand("help", new HelpCommand());
        addCommand("exit", new ExitCommand());
        addCommand("execute_script", new ExecuteScriptCommand());
    }

    public class HelpCommand implements Command{
        @Override
        public void execute(String arg) {
            ioManager.printlnForce(getHelp());
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

    public class ExecuteScriptCommand implements Command{
        @Override
        public void execute(String arg) {
            executeScript(arg);
        }

        @Override
        public String toString() {
            return "считать и исполнить скрипт из указанного файла";
        }
    }

    public void work(){
        isRunning = true;
        ioManager.println("Программа запущена\nДля получения справки введите команду help");

        try {
            while (isRunning) {
                CommandWrapper cmdPair = ioManager.readCommand();

                try {
                    execute(cmdPair.getCommand(), cmdPair.getArgument());
                } catch (IllegalStateException e) {
                    ioManager.printErr(e.getMessage() + "\nСписок команд можно получить с помощью команды help");
                }
            }
        }
        catch (EmptyStackException e){
            ioManager.printErr("EOF\nexiting...");
            isRunning = false;
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

    private void executeScript(String path){
        if (path == null || path.length() == 0){
            ioManager.printErr("Не введен путь к файлу");
            return;
        }

        ioManager.setFileInput(path);
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

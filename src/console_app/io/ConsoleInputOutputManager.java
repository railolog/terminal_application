package console_app.io;

import console_app.commands.CommandWrapper;
import console_app.core.City;
import console_app.core.Coordinates;
import console_app.core.Government;
import console_app.core.Human;

import java.util.Scanner;

public class ConsoleInputOutputManager implements InputOutputManager{
    Scanner in;

    public ConsoleInputOutputManager(){
        in = new Scanner(System.in);
    }

    @Override
    public CommandWrapper readCommand() {
        String cmd = "";

        while(cmd.length() == 0) {
            cmd = in.nextLine().trim();
        }

        if (cmd.contains(" ")){
            String[] arr = cmd.split(" ", 2);
            return new CommandWrapper(arr[0], arr[1].trim());
        }

        return new CommandWrapper(cmd);
    }

    @Override
    public void println(String line) {
        System.out.println(line);
    }

    @Override
    public City readCity() {
        String name = readName();
        Coordinates coords = readCoordinates();
        Double area = readAre();
        Integer population = readPopulation();
        Long meters = readMetersAboveSeaLevel();
        boolean capital = readCapital();
        int telephoneCode = readTelephoneCode();
        Government gov = readGovernment();
        Human governor = readGovernor();

        return new City(name, coords, area, population, meters, capital, telephoneCode, gov, governor);
    }
}

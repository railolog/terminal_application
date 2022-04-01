package console_app.io;

import console_app.commands.CommandWrapper;
import console_app.core.City;
import console_app.core.Coordinates;
import console_app.core.Government;
import console_app.core.Human;
import console_app.exceptions.HumanException;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class ConsoleInputOutputManager implements InputOutputManager{
    Scanner sc;
    boolean fileMode = false;

    public ConsoleInputOutputManager(Scanner sc){
        this.sc = sc;
    }

    @Override
    public CommandWrapper readCommand() {
        String cmd = "";

        while(cmd.length() == 0) {
            cmd = sc.nextLine().trim();
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
    public void print(String line) {
        if (!fileMode) {
            System.out.print(line);
        }
    }

    @Override
    public void printErr(String e) {
        System.out.println("Ошибка: " + e);
    }

    @Override
    public String readLine() {
        return sc.nextLine().trim();
    }

    @Override
    public City readCity() {
        String name = readName();
        Coordinates coords = readCoordinates();
        Double area = readArea();
        Integer population = readPopulation();
        Long meters = readMetersAboveSeaLevel();
        boolean capital = readCapital();
        int telephoneCode = readTelephoneCode();
        Government gov = readGovernment();
        Human governor = readGovernor();

        return new City(name, coords, area, population, meters, capital, telephoneCode, gov, governor);
    }

    private String readName(){
        print("Введите название города(поле не может быть пустым): ");
        String name = readLine();

        if(name.length() == 0){
            printErr("поле не может быть пустым");
            return readName();
        }
        return name;
    }

    private Coordinates readCoordinates(){
        print("Введите координаты(может быть десятичной дробью) через пробел: ");
        String[] xy = readLine().replaceAll(",", ".").split("\s+");

        if (xy.length != 2){
            printErr("введено неверное кол-во чисел, предполагаемое кол-во - 2");
            return readCoordinates();
        }

        try {
            return new Coordinates(Float.parseFloat(xy[0]), Float.parseFloat(xy[1]));
        }
        catch (NumberFormatException e){
            printErr("вероятно, введены не числа");
            return readCoordinates();
        }
    }

    private Double readArea(){
        print("Введите площадь(> 0, поле не может быть пустым): ");
        double area;

        try {
            area = Double.parseDouble(readLine());
        }
        catch (NumberFormatException e){                // пустой ввод
            printErr("вероятно, введено не число");
            return readArea();
        }

        if (area <= 0){
            printErr("вы ввели значение меньше нуля");
            return readArea();
        }
        return area;
    }

    private Integer readPopulation(){
        print("Введите кол-во жителей: ");
        int pop;

        try{
            pop = Integer.parseInt(readLine());
        }
        catch (NumberFormatException e){
            if (e.getMessage().equals("empty String")){
                printErr("поле не может быть пустым");    // не работает с целыми числами
                return readPopulation();
            }
            printErr("вероятно, введено не целое число");
            return readPopulation();
        }

        if (pop <= 0){
            printErr("вы ввели значение меньше нуля");
            return readPopulation();
        }
        return pop;
    }

    private Long readMetersAboveSeaLevel(){
        print("Введите высоту на уровне моря(целое число): ");
        long meters;

        try{
            meters = Integer.parseInt(readLine());
        }
        catch (NumberFormatException e){
            if (e.getMessage().equals("empty String")){    // не рабоает с интом
                return null;
            }
            printErr("введено не целое число");
            return readMetersAboveSeaLevel();
        }

        return meters;
    }

    private boolean readCapital(){
        print("Город - столица? (Y/N, 1/0, Yes/No, Д/Н, Да/Нет): ");
        String ans = readLine().toLowerCase();

        String[] yes = new String[] {"y", "1", "yes", "д", "да"};    // make repeation
        String[] no = new String[] {"n", "0", "no", "н", "нет"};

        if (Arrays.asList(yes).contains(ans)){
            return true;
        }
        else if (Arrays.asList(no).contains(ans)){
            return false;
        }
        return false;
    }

    private int readTelephoneCode(){
        print("Введите телефонный код: ");
        int code;

        try{
            code = Integer.parseInt(readLine());
        }
        catch (NumberFormatException e){
            if (e.getMessage().equals("empty String")){
                printErr("поле не может быть пустым");
            }
            else {
                printErr("введено не число");
            }
            return readTelephoneCode();
        }

        return code;
    }

    private Government readGovernment(){
        Government[] governments = Government.values();

        println("Введите тип правления или пропустите");
        int a = 1, b = governments.length;

        for (int i = 0; i < b; i++){
            println(governments[i] + ": " + (i + 1));
        }

        int input;
        try{
            input = Integer.parseInt(readLine());
        }
        catch (NumberFormatException e){
            if (e.getMessage().equals("empty String")){
                return null;
            }
            printErr("Введно не целое число");
            return readGovernment();
        }

        if (input > b || input < a){
            printErr("Введено число не из промежутка");
            return readGovernment();
        }

        return governments[input - 1];
    }

    private Human readGovernor(){
        print("Введите рост правителя: ");
        double height;

        try {
            height = Double.parseDouble(readLine());
        }
        catch (NumberFormatException e){
            printErr("Введено не вещественное число");
            return readGovernor();
        }

        try {
            return new Human(height);
        }
        catch (HumanException e){
            printErr(e.getMessage());
            return readGovernor();
        }
    }
}

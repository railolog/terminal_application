package project_5.core;

import project_5.exceptions.EmptyNameException;

public class City {
    private static long idCounter = 1;

    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Double area; //Значение поля должно быть больше 0, Поле не может быть null
    private Integer population; //Значение поля должно быть больше 0, Поле не может быть null
    private Long metersAboveSeaLevel;
    private boolean capital;
    private int telephoneCode; //Значение поля должно быть больше 0, Максимальное значение поля: 100000
    private Government government; //Поле может быть null
    private Human governor; //Поле может быть null

    public City(String name,
                Coordinates coordinates,
                Double area,
                Integer population){
        if(name.trim().isEmpty()){
            throw new EmptyNameException("Имя не может быть пустым");
        }
    }
}

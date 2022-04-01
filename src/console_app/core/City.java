package console_app.core;

import console_app.exceptions.EmptyFieldException;

public class City implements Comparable<City>{
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
                Integer population,
                Long metersAboveSeaLevel,
                boolean capital,
                int telephoneCode,
                Government government,
                Human governor){
        this.name = name;
        this.coordinates = coordinates;
        this.area = area;
        this.population = population;
        this.metersAboveSeaLevel = metersAboveSeaLevel;
        this.capital = capital;
        this.telephoneCode = telephoneCode;
        this.government = government;
        this.governor = governor;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    @Override
    public int compareTo(City o) {
        return population.compareTo(o.population);
    }

    public String toString(){
        return "City{" +
                "id=" + id +
                ", name='" + name + "'" +
                ", coordinate=" + coordinates +
                ", creation_date=" + creationDate +
                ", area=" + area +
                ", population=" + population +
                ", meters_above_sea_level=" + metersAboveSeaLevel +
                ", is_capital=" + capital +
                ", telephone_code=" + telephoneCode +
                ", government=" + government +
                ", governor=" + governor;
    }
}

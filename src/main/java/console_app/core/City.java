package console_app.core;

import console_app.exceptions.CityInteractionException;
import console_app.exceptions.EmptyFieldException;

import java.time.ZonedDateTime;

public class City implements Comparable<City>{
    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
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
        creationDate = ZonedDateTime.now();
        setName(name);
        setCoordinates(coordinates);
        setArea(area);
        setPopulation(population);
        setMetersAboveSeaLevel(metersAboveSeaLevel);
        setCapital(capital);
        setTelephoneCode(telephoneCode);
        setGovernor(governor);
        setGovernment(government);
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public void setName(String name){
        if (name == null || name.trim().length() == 0){
            throw new CityInteractionException("Поле name не может быть пустым или null");
        }
        this.name = name;
    }

    public void setCoordinates(Coordinates coords){
        if (coords == null){
            throw new CityInteractionException("Поле Coordinates не может быть null");
        }
        this.coordinates = coords;
    }

    public void setArea(Double area) {
        if (area == null){
            throw new CityInteractionException("Поле area не может быть null");
        }
        if (area <= 0){
            throw new CityInteractionException("Поле area должно быть больше 0");
        }
        this.area = area;
    }

    public void setPopulation(Integer population) {
        if (population == null){
            throw new CityInteractionException("Поле population не может быть null");
        }
        if (population <= 0){
            throw new CityInteractionException("Поле population должно быть больше 0");
        }
        this.population = population;
    }

    public void setMetersAboveSeaLevel(Long metersAboveSeaLevel) {
        this.metersAboveSeaLevel = metersAboveSeaLevel;
    }

    public void setCapital(boolean capital) {
        this.capital = capital;
    }

    public void setTelephoneCode(int telephoneCode) {
        if (telephoneCode > 100000 || telephoneCode <= 0){
            throw new CityInteractionException("Значение поля telephoneCode не из промежутка [1;100000]");
        }
        this.telephoneCode = telephoneCode;
    }

    public void setGovernment(Government government) {
        this.government = government;
    }

    public void setGovernor(Human governor) {
        this.governor = governor;
    }

    public ZonedDateTime getCreationDate(){
        return creationDate;
    }

    public Long getMetersAboveSeaLevel(){
        return metersAboveSeaLevel;
    }

    @Override
    public int compareTo(City o) {
        return population.compareTo(o.population);
    }

    @Override
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
                ", governor=" + governor +
                "}";
    }
}

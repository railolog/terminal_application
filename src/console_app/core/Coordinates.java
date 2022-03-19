package console_app.core;

import console_app.exceptions.ValueLimitExceedException;

public class Coordinates {
    private Float x;
    private Float y;

    public Coordinates(Float x, Float y){
        setX(x);
        setY(y);
    }

    public void setX(Float x) throws ValueLimitExceedException{
        if (x > 98){
            throw new ValueLimitExceedException("Некорректный ввод: максимальное значения поля x: 98");
        }
        this.x = x;
    }

    public void setY(Float y) throws ValueLimitExceedException{
        if (y > 761){
            throw new ValueLimitExceedException("Некорректный ввод: максимальное значения поля y: 761");
        }
        this.y = y;
    }
}

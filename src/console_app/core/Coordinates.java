package console_app.core;

import console_app.exceptions.HumanHeightException;

public class Coordinates {
    private Float x;
    private Float y;

    public Coordinates(Float x, Float y){
        setX(x);
        setY(y);
    }

    public void setX(Float x) throws HumanHeightException {
        if (x > 98){
            throw new HumanHeightException("Некорректный ввод: максимальное значения поля x: 98");
        }
        this.x = x;
    }

    public void setY(Float y) throws HumanHeightException {
        if (y > 761){
            throw new HumanHeightException("Некорректный ввод: максимальное значения поля y: 761");
        }
        this.y = y;
    }
}

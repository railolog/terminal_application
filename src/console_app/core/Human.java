package console_app.core;

import console_app.exceptions.ValueLimitExceedException;

public class Human {
    private Double height;

    public Human(){

    }

    public Human(Double height){
        setHeight(height);
    }

    public void setHeight(Double height){
        if(height <= 0){
            throw new ValueLimitExceedException("Значение поля height должно быть больше 0");
        }
    }
}

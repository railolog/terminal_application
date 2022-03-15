package project_5.core;

import project_5.exceptions.ValueLimitExceedException;

public class Human {
    private Double height;

    public Human(){

    }

    public Human(Double height){
        setHeight(height);
    }

    public void setHeight(Double height){
        if(height <= 0){
            throw new ValueLimitExceedException("Значение поля должно быть больше 0");
        }
    }
}

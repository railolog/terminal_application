package console_app.core;

import console_app.exceptions.HumanHeightException;

public class Human {
    private Double height;

    public Human(){

    }

    public Human(Double height){
        setHeight(height);
    }

    public void setHeight(Double height){
        if(height <= 0){
            throw new HumanHeightException("Значение поля height должно быть больше 0");
        }
        this.height = height;
    }

    @Override
    public String toString() {
        return "Human{height=" + height + "}";
    }
}

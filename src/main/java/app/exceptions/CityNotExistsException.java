package app.exceptions;

public class CityNotExistsException extends CityInteractionException{
    public CityNotExistsException(String msg){
        super(msg);
    }
}

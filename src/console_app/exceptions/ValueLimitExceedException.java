package console_app.exceptions;

public class ValueLimitExceedException extends RuntimeException{
    public ValueLimitExceedException(String message){
        super(message);
    }
}

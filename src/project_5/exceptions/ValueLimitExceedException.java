package project_5.exceptions;

public class ValueLimitExceedException extends RuntimeException{
    public ValueLimitExceedException(String message){
        super(message);
    }
}

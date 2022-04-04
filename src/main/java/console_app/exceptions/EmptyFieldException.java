package console_app.exceptions;

public class EmptyFieldException extends RuntimeException{
    public EmptyFieldException(String message){
        super(message);
    }
}

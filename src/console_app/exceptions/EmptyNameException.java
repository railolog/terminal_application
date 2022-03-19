package console_app.exceptions;

public class EmptyNameException extends RuntimeException{
    public EmptyNameException(String message){
        super(message);
    }
}

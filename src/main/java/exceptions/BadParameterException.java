package exceptions;

public class BadParameterException extends Exception {

    public BadParameterException() {
        super();
    }

    public BadParameterException(String message) {
        super(message);
    }

    public BadParameterException(String message, Throwable e) {
        super(message, e);
    }
}

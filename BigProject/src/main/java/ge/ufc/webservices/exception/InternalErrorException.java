package ge.ufc.webservices.exception;

public class InternalErrorException extends Exception {
    private static final long serialVersionUID = 1L;
    
    public InternalErrorException(String message) {
        super(message);
    }
}
package ge.ufc.webservices.exception;

public class AmountNotPositiveException extends Exception {
    private static final long serialVersionUID = 1L;
    
    public AmountNotPositiveException(String message) {
        super(message);
    }
}
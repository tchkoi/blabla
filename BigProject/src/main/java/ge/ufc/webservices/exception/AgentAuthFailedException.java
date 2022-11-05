package ge.ufc.webservices.exception;

public class AgentAuthFailedException extends Exception {
    private static final long serialVersionUID = 1L;
    
    public AgentAuthFailedException(String message) {
        super(message);
    }
}
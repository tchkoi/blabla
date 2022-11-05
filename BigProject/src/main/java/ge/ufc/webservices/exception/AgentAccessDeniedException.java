package ge.ufc.webservices.exception;

public class AgentAccessDeniedException extends Exception {
    private static final long serialVersionUID = 1L;
    
    public AgentAccessDeniedException(String message) {
        super(message);
    }
}
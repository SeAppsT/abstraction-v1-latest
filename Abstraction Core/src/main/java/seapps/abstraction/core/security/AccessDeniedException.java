package seapps.abstraction.core.security;

public class AccessDeniedException extends Exception{

    private String message;

    public AccessDeniedException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
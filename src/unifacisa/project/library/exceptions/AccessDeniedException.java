package unifacisa.project.library.exceptions;

public class AccessDeniedException extends RuntimeException {
    public AccessDeniedException(String message) {
        super(message);
    }

    public AccessDeniedException() {
        super("You dont have permission to perform this operation!");
    }
}

package unifacisa.project.library.model.exceptions;

public class InvalidCredentialsException extends Exception {
    public InvalidCredentialsException(String message) {
        super(message);
    }

    public InvalidCredentialsException() {
        super("Invalid email or password!");
    }
}

package unifacisa.project.library.exceptions;

public class MovieUnavailableException extends RuntimeException {
    public MovieUnavailableException(String message) {
        super(message);
    }

    public MovieUnavailableException(String title, String status) {
        super(String.format("Movie \"%s\" is not available for loan (status: %s).", title, status));
    }
}

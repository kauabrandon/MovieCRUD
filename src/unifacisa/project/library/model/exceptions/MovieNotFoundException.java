package unifacisa.project.library.model.exceptions;

public class MovieNotFoundException extends RuntimeException {
    public MovieNotFoundException(String message) {
        super(message);
    }

    public MovieNotFoundException(Long id) {
        super("Movie not found! | id: " + id);
    }
}

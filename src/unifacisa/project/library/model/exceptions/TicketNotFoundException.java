package unifacisa.project.library.model.exceptions;

public class TicketNotFoundException extends RuntimeException {
    public TicketNotFoundException(String message) {
        super(message);
    }

    public TicketNotFoundException(Long id) {
        super("Ticket not found! | id: " + id);
    }
}

package unifacisa.project.library.exceptions;

public class LoanNotFoundException extends RuntimeException {
    public LoanNotFoundException(String message) {
        super(message);
    }

    public LoanNotFoundException(Long id) {
        super("Loan not found! | id: " + id);
    }
}

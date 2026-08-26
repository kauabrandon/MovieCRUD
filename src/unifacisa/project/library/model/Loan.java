package unifacisa.project.library.model;

import java.time.LocalDate;
import java.util.Objects;

public class Loan {
    private Long id;
    private CommonUser user;
    private Movie movie;
    private LocalDate loanDate;
    private LocalDate dueDate;
    private LocalDate returnDate;
    private boolean returned;

    public Loan(Long id, CommonUser user, Movie movie, LocalDate loanDate, LocalDate dueDate) {
        this.id = id;
        this.user = user;
        this.movie = movie;
        this.loanDate = loanDate;
        this.dueDate = dueDate;
        this.returned = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CommonUser getUser() {
        return user;
    }

    public void setUser(CommonUser user) {
        this.user = user;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public boolean isReturned() {
        return returned;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
    }

    public void registerReturn(LocalDate returnDate) {
        this.returnDate = returnDate;
        this.returned = true;
    }

    public boolean isOverdue() {
        if (returned) {
            return returnDate.isAfter(dueDate);
        }
        return LocalDate.now().isAfter(dueDate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Loan)) return false;
        Loan loan = (Loan) o;
        return Objects.equals(id, loan.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return String.format("Loan #%d -> %s (due: %s)", id, movie.getTitle(), user.getName(), dueDate);
    }
}

package unifacisa.project.library.services;

import unifacisa.project.library.enums.MovieStatus;
import unifacisa.project.library.exceptions.*;
import unifacisa.project.library.interfaces.CrudService;
import unifacisa.project.library.model.CommonUser;
import unifacisa.project.library.model.Loan;
import unifacisa.project.library.model.Movie;
import unifacisa.project.library.model.User;
import unifacisa.project.library.repo.LoanRepository;
import unifacisa.project.library.repo.MovieRepository;
import unifacisa.project.library.repo.UserRepository;

import java.time.LocalDate;
import java.util.List;

public class LoanService implements CrudService<Loan> {
    private static final int LOANDAYS = 14;
    private final LoanRepository loanRepository;
    private final MovieRepository movieRepository;
    private final UserRepository userRepository;

    public LoanService(LoanRepository loanRepository, MovieRepository movieRepository, UserRepository userRepository) {
        this.loanRepository = loanRepository;
        this.movieRepository = movieRepository;
        this.userRepository = userRepository;
    }

    public Loan borrowMovie(Long userId, Long movieId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));

        if (!(user instanceof CommonUser)) {
            throw new OperationNotAllowedException("Only common users can borrow movies!");
        }
        Movie movie = movieRepository.findById(movieId).orElseThrow(() -> new MovieNotFoundException(movieId));

        if (!movie.isAvailable()) {
            throw new MovieUnavailableException(movie.getTitle(), movie.getMovieStatus().getDescMS());
        }

        CommonUser commonUser = (CommonUser) user;

        Loan loan = new Loan(null, commonUser, movie, LocalDate.now(), LocalDate.now().plusDays(LOANDAYS));
        loanRepository.save(loan);

        movie.setMovieStatus(MovieStatus.BORROWED);
        movieRepository.update(movie);

        commonUser.addLoan(loan);

        return loan;
    }

    public Loan returnMovie(Long loanId) {
        Loan loan = findById(loanId);

        loan.registerReturn(LocalDate.now());
        loanRepository.update(loan);

        Movie movie = loan.getMovie();
        movie.setMovieStatus(MovieStatus.AVAILABLE);
        movieRepository.update(movie);

        loan.getUser().removedLoan(loan);

        return loan;
    }

    public List<Loan> findLoansByUser(Long userId) {
        return loanRepository.findByUserId(userId);
    }

    @Override
    public Loan create(Loan entity) {
        return loanRepository.save(entity);
    }

    @Override
    public Loan findById(Long id) {
        return loanRepository.findById(id).orElseThrow(() -> new LoanNotFoundException(id));
    }

    @Override
    public List<Loan> findAll() {
        return loanRepository.findAll();
    }

    @Override
    public Loan update(Long id, Loan entity) {
        findById(id);
        entity.setId(id);
        return loanRepository.update(entity);
    }

    @Override
    public void delete(Long id) {
        findById(id);
        loanRepository.deleteById(id);
    }
}

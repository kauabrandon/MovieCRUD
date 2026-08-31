package unifacisa.project.library.controllers;

import unifacisa.project.library.enums.PriorityLevel;
import unifacisa.project.library.exceptions.MovieNotFoundException;
import unifacisa.project.library.exceptions.MovieUnavailableException;
import unifacisa.project.library.model.CommonUser;
import unifacisa.project.library.model.Loan;
import unifacisa.project.library.model.Movie;
import unifacisa.project.library.model.QuestionSupport;
import unifacisa.project.library.services.LoanService;
import unifacisa.project.library.services.MovieService;
import unifacisa.project.library.services.SupportService;

import javax.swing.*;
import java.util.List;
import java.util.stream.Collectors;

public class UserMenu {
    private static final String[] OPTIONS = {"Search movie", "Borrow movie", "Return movie", "Open support ticket", "Exit"};

    private final MovieService movieService;
    private final LoanService loanService;
    private final SupportService supportService;

    public UserMenu(MovieService movieService, LoanService loanService, SupportService supportService) {
        this.movieService = movieService;
        this.loanService = loanService;
        this.supportService = supportService;
    }

    public void show(CommonUser user) {
        boolean inMenu = true;
        while (inMenu) {
            int choice = JOptionPane.showOptionDialog(null, "Logged in as: " + user.getName(), "User menu", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, OPTIONS, OPTIONS[0]);
            switch (choice) {
                case 0 -> searchMovie();
                case 1 -> borrowMovie(user);
                case 2 -> returnMovie(user);
                case 3 -> openTicket(user);
                default -> inMenu = false;
            }
        }
    }

    private void searchMovie() {
        String title = JOptionPane.showInputDialog(null, "Title to search:");

        if (title == null) return;

        List<Movie> results = movieService.searchByTitle(title);

        if (results.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No movies found.");
            return;
        }

        String message = results.stream().map(Movie::toString).collect(Collectors.joining("\n"));
        JOptionPane.showMessageDialog(null, message, "Search Results", JOptionPane.INFORMATION_MESSAGE);
    }

    private void borrowMovie(CommonUser user) {
        String input = JOptionPane.showInputDialog(null, "Movie id:");
        if (input == null) return;

        try {
            Long movieId = Long.parseLong(input.trim());
            loanService.borrowMovie(user.getId(), movieId);
            JOptionPane.showMessageDialog(null, "Movie borrowed successfully! | Due in 14 days!");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid Id", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (MovieNotFoundException | MovieUnavailableException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void returnMovie(CommonUser user) {
        List<Loan> activeLoans = user.getActiveLoans();

        if (activeLoans.isEmpty()) {
            JOptionPane.showMessageDialog(null, "You have no active loans!");
            return;
        }

        String loansMessage = activeLoans.stream().map(Loan::toString).collect(Collectors.joining("\n"));
        JOptionPane.showMessageDialog(null, loansMessage, "Your active loans", JOptionPane.INFORMATION_MESSAGE);

        String input = JOptionPane.showInputDialog(null, "Loan id to return:");
        if (input == null) return;

        try {
            Long loanId = Long.parseLong(input.trim());
            loanService.returnMovie(loanId);
            JOptionPane.showMessageDialog(null, "Movie return successfully");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid id!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void openTicket(CommonUser user) {
        String subject = JOptionPane.showInputDialog(null, "Subject:");
        if (subject == null) return;

        String description = JOptionPane.showInputDialog(null, "Description:");
        if (description == null) return;

        String topic = JOptionPane.showInputDialog(null, "Topic:");
        if (topic == null) return;

        QuestionSupport ticket = new QuestionSupport(null, user, subject, description, PriorityLevel.MEDIUM, topic);
        supportService.create(ticket);
        JOptionPane.showMessageDialog(null, "Support ticket opened successfully!");
    }
}

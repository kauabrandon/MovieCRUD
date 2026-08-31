package unifacisa.project.library.controllers;

import unifacisa.project.library.enums.MovieGenre;
import unifacisa.project.library.exceptions.MovieNotFoundException;
import unifacisa.project.library.model.Admin;
import unifacisa.project.library.model.Movie;
import unifacisa.project.library.model.User;
import unifacisa.project.library.services.MovieService;
import unifacisa.project.library.services.SupportService;
import unifacisa.project.library.services.UserService;

import javax.swing.*;
import java.util.List;
import java.util.stream.Collectors;

public class AdminMenu {
    private static final String[] OPTIONS = {
            "Register movie", "Edit movie", "Remove movie", "List users", "Manage support tickets", "Exit"
    };

    private final MovieService movieService;
    private final UserService userService;
    private final SupportMenu supportMenu;


    public AdminMenu(MovieService movieService, UserService userService, SupportMenu supportMenu) {
        this.movieService = movieService;
        this.userService = userService;
        this.supportMenu = supportMenu;
    }

    public void show(Admin admin) {
        boolean inMenu = true;
        while (inMenu) {
            int choice = JOptionPane.showOptionDialog(null, "Logged in as: " + admin.getName(), "Administrator menu", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, OPTIONS, OPTIONS[0]);

            switch (choice) {
                case 0 -> registerMovie();
                case 1 -> editMovie();
                case 2 -> removeMovie();
                case 3 -> listUsers();
                case 4 -> supportMenu.show();
                default -> inMenu = false;
            }
        }
    }

    private void registerMovie() {
        String title = JOptionPane.showInputDialog(null, "Title:");
        if (title == null) return;

        String director = JOptionPane.showInputDialog(null, "Director:");
        if (director == null) return;

        String yearInput = JOptionPane.showInputDialog(null, "Release year:");
        if (yearInput == null) return;

        MovieGenre genre = (MovieGenre) JOptionPane.showInputDialog(null, "Genre:", "Genre", JOptionPane.QUESTION_MESSAGE, null, MovieGenre.values(), MovieGenre.values()[0]);
        if (genre == null) return;

        String synopsis = JOptionPane.showInputDialog(null, "Synopsis:");
        if (synopsis == null) return;

        try {
            int year = Integer.parseInt(yearInput.trim());
            Movie movie = new Movie(null, title, director, year, genre, synopsis);
            movieService.create(movie);
            JOptionPane.showMessageDialog(null, "Movie registered successfully");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid year!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void editMovie() {
        Long id = readMovieId();
        if (id == null) return;

        try {
            Movie movie = movieService.findById(id);

            String newTitle = JOptionPane.showInputDialog(null, "New title:", movie.getTitle());
            if (newTitle != null) movie.setTitle(newTitle);

            String newDirector = JOptionPane.showInputDialog(null, "New director:", movie.getDirector());

            if (newDirector != null) movie.setDirector(newDirector);

            movieService.update(id, movie);
            JOptionPane.showMessageDialog(null, "Movie updated successfully!");
        } catch (MovieNotFoundException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void removeMovie() {
        Long id = readMovieId();
        if (id == null) return;

        try {
            movieService.delete(id);
            JOptionPane.showMessageDialog(null, "Movie removed successfully");
        } catch (MovieNotFoundException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void listUsers() {
        List<User> users = userService.findAll();

        if (users.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No users registered!");
            return;
        }
        String message = users.stream().map(User::toString).collect(Collectors.joining("\n"));
        JOptionPane.showMessageDialog(null, message, "Users", JOptionPane.INFORMATION_MESSAGE);
    }

    private Long readMovieId() {
        String input = JOptionPane.showInputDialog(null, "Movie id:");
        if (input == null) return null;

        try {
            return Long.parseLong(input.trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid id!", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}

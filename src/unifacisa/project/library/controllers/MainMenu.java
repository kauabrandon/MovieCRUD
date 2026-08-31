package unifacisa.project.library.controllers;

import unifacisa.project.library.exceptions.InvalidCredentialsException;
import unifacisa.project.library.model.Admin;
import unifacisa.project.library.model.CommonUser;
import unifacisa.project.library.model.User;
import unifacisa.project.library.services.AuthenticationService;
import unifacisa.project.library.services.UserService;

import javax.swing.*;

public class MainMenu {
    private static final String[] OPTIONS = {"Login", "Register", "Exit"};

    private final AuthenticationService authenticationService;
    private final UserService userService;
    private final AdminMenu adminMenu;
    private final UserMenu userMenu;

    public MainMenu(AuthenticationService authenticationService, UserService userService, AdminMenu adminMenu, UserMenu userMenu) {
        this.authenticationService = authenticationService;
        this.userService = userService;
        this.adminMenu = adminMenu;
        this.userMenu = userMenu;
    }

    public void start() {
        boolean running = true;
        while (running) {
            int choice = JOptionPane.showOptionDialog(null, "Welcome to the movie library!", "Movie library", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, OPTIONS, OPTIONS[0]);

            switch (choice) {
                case 0 -> handleLogin();
                case 1 -> handleRegistration();
                default -> running = false;
            }
        }
        JOptionPane.showMessageDialog(null, "Bye, my friend!");
    }

    private void handleLogin() {
        String email = JOptionPane.showInputDialog(null, "Email:");
        if (email == null) return;

        String password = JOptionPane.showInputDialog(null, "Password:");
        if (password == null) return;

        try {
            User user = authenticationService.login(email, password);
            JOptionPane.showMessageDialog(null, "Welcome " + user.getName() + "!");

            if (user instanceof Admin admin) {
                adminMenu.show(admin);
            } else if (user instanceof CommonUser commonUser) {
                userMenu.show(commonUser);
            }
        } catch (InvalidCredentialsException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Login failed", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void handleRegistration() {
        String name = JOptionPane.showInputDialog(null, "Name:");
        if (name == null) return;

        String email = JOptionPane.showInputDialog(null, "Email:");
        if (email == null) return;

        String password = JOptionPane.showInputDialog(null, "Password:");
        if (password == null) return;

        CommonUser newUser = new CommonUser(null, name, email, password);
        userService.create(newUser);
        JOptionPane.showMessageDialog(null, "Account created successfully! you can now login!");
    }

    private String readPassword(String message) {
        JPasswordField passwordField = new JPasswordField();
        int option = JOptionPane.showConfirmDialog(null, passwordField, message, JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            return new String(passwordField.getPassword());
        }
        return null;
    }
}

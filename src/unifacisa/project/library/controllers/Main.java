package unifacisa.project.library.controllers;

import unifacisa.project.library.model.Admin;
import unifacisa.project.library.repo.LoanRepository;
import unifacisa.project.library.repo.MovieRepository;
import unifacisa.project.library.repo.SupportRepository;
import unifacisa.project.library.repo.UserRepository;
import unifacisa.project.library.services.*;

public class Main {
    static void main(String[] args) {
        UserRepository userRepository = new UserRepository();
        MovieRepository movieRepository = new MovieRepository();
        LoanRepository loanRepository = new LoanRepository();
        SupportRepository supportRepository = new SupportRepository();

        userRepository.save(new Admin(null, "adm", "kaua@adm.com", "admin"));

        AuthenticationService authenticationService = new AuthenticationService(userRepository);
        UserService userService = new UserService(userRepository);
        MovieService movieService = new MovieService(movieRepository);
        LoanService loanService = new LoanService(loanRepository, movieRepository, userRepository);
        SupportService supportService = new SupportService(supportRepository);

        SupportMenu supportMenu = new SupportMenu(supportService);
        AdminMenu adminMenu = new AdminMenu(movieService, userService, supportMenu);
        UserMenu userMenu = new UserMenu(movieService, loanService, supportService);
        MainMenu mainMenu = new MainMenu(authenticationService, userService, adminMenu, userMenu);

        mainMenu.start();
    }
}

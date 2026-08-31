package unifacisa.project.library.services;

import unifacisa.project.library.exceptions.InvalidCredentialsException;
import unifacisa.project.library.interfaces.Authenticatable;
import unifacisa.project.library.model.User;
import unifacisa.project.library.repo.UserRepository;

import java.util.Optional;

public class AuthenticationService implements Authenticatable {
    private final UserRepository userRepository;
    private User loggedInUser;

    public AuthenticationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User login(String email, String password) throws InvalidCredentialsException {
        Optional<User> found = userRepository.findByEmail(email);

        if (found.isEmpty() || !found.get().autheticate(password)) {
            throw new InvalidCredentialsException();
        }
        this.loggedInUser = found.get();
        return this.loggedInUser;
    }

    @Override
    public void logout() {
        this.loggedInUser = null;
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }
}

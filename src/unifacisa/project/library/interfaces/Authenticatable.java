package unifacisa.project.library.interfaces;

import unifacisa.project.library.exceptions.InvalidCredentialsException;
import unifacisa.project.library.model.User;

public interface Authenticatable {

    User login(String email, String password) throws InvalidCredentialsException;

    void logout();
}

package unifacisa.project.library.interfaces;

import unifacisa.project.library.enums.UserType;
import unifacisa.project.library.exceptions.AccessDeniedException;
import unifacisa.project.library.model.User;

public interface Permission {
    void checkAccess(User user, UserType requiredType) throws AccessDeniedException;
}

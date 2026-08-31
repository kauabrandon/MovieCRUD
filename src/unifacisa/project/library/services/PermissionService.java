package unifacisa.project.library.services;

import unifacisa.project.library.enums.UserType;
import unifacisa.project.library.exceptions.AccessDeniedException;
import unifacisa.project.library.interfaces.Permission;
import unifacisa.project.library.model.User;

public class PermissionService implements Permission {

    @Override
    public void checkAccess(User user, UserType requiredType) throws AccessDeniedException {
        if (user == null) {
            throw new AccessDeniedException("No authenticated user!");
        }
        if (user.getUserType() != requiredType) {
            throw new AccessDeniedException(String.format("This operation requires %s access.", requiredType.getDescUT()));
        }
    }
}

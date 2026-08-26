package unifacisa.project.library.model;

import unifacisa.project.library.model.enums.AccessLevel;
import unifacisa.project.library.model.enums.UserType;

public class Admin extends User{
    private AccessLevel accessLevel;

    public Admin(Long id, String name, String email, String password) {
        super(id, name, email, password);
        this.accessLevel = AccessLevel.FULL;
    }

    public Admin(Long id, String name, String email, String password, AccessLevel accessLevel) {
        super(id, name, email, password);
        this.accessLevel = accessLevel;
    }

    public AccessLevel getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(AccessLevel accessLevel) {
        this.accessLevel = accessLevel;
    }

    @Override
    public UserType getUserType() {
        return UserType.ADMIN;
    }

    @Override
    public void showMenu() {
        System.out.println("---- Admin Menu ----\n1 - Register movie\n2 - Edit movie\n3 - Remove movie\n4 - List users\n5 - Manage support calls\n6 - Exit");
    }
}

package unifacisa.project.library.model.enums;

public enum UserType {
    COMMON("Common User"), ADMIN("Administrator");

    private final String descUT;

    UserType(String descUT) {
        this.descUT = descUT;
    }

    public String getDescUT() {
        return descUT;
    }
}

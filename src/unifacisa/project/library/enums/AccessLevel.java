package unifacisa.project.library.enums;

public enum AccessLevel {
    STANDARD("Standard Access"), FULL("Full Access");

    private final String descAL;

    AccessLevel(String descAL) {
        this.descAL = descAL;
    }

    public String getDescAL() {
        return descAL;
    }
}

package unifacisa.project.library.enums;

public enum MovieStatus {
    AVAILABLE("Available"), UNAVAILABLE("Unavailable"), BORROWED("Borrowed");

    private final String descMS;

    MovieStatus(String descMS) {
        this.descMS = descMS;
    }

    public String getDescMS() {
        return descMS;
    }
}

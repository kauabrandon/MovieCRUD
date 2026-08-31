package unifacisa.project.library.enums;

public enum SupportStatus {
    OPEN("Open"), INPROGRESS("In-Progress"), RESOLVED("Resolved"), CLOSED("Closed");

    private final String descSS;

    SupportStatus(String descSS) {
        this.descSS = descSS;
    }

    public String getDescSS() {
        return descSS;
    }
}

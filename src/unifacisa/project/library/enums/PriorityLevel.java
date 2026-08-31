package unifacisa.project.library.enums;

public enum PriorityLevel {
    LOW("Low Priority"), MEDIUM("Medium Priority"), HIGH("High Priority"), URGENT("Urgent Priority");

    private final String descPL;

    PriorityLevel(String descPL) {
        this.descPL = descPL;
    }

    public String getDescPL() {
        return descPL;
    }
}

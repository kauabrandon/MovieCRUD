package unifacisa.project.library.model.enums;

public enum SupportType {
    TECHNICAL("Technical"), QUESTION("Question"), COMPLAINT("Complaint");

    private final String descST;

    SupportType(String descST) {
        this.descST = descST;
    }

    public String getDescST() {
        return descST;
    }
}

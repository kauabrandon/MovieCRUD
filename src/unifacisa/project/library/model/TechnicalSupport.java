package unifacisa.project.library.model;

import unifacisa.project.library.enums.PriorityLevel;
import unifacisa.project.library.enums.SupportType;

public class TechnicalSupport extends Support{
    private String affectedComponent;

    public TechnicalSupport(Long id, User requester, String subject, String description, PriorityLevel priorityLevel, String affectedComponent) {
        super(id, requester, subject, description, priorityLevel);
        this.affectedComponent = affectedComponent;
    }

    public String getAffectedComponent() {
        return affectedComponent;
    }

    public void setAffectedComponent(String affectedComponent) {
        this.affectedComponent = affectedComponent;
    }

    @Override
    public SupportType getType() {
        return SupportType.TECHNICAL;
    }

    @Override
    public String getHandlingInstructions() {
        return "Forward to the technical team responsible for: " + affectedComponent;
    }
}

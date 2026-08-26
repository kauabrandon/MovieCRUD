package unifacisa.project.library.model;

import unifacisa.project.library.model.enums.PriorityLevel;
import unifacisa.project.library.model.enums.SupportType;

public class ComplaintSupport extends Support{
    private String reportedDepartment;

    protected ComplaintSupport(Long id, User requester, String subject, String description, PriorityLevel priorityLevel, String reportedDepartment) {
        super(id, requester, subject, description, priorityLevel);
        this.reportedDepartment = reportedDepartment;
    }

    public String getReportedDepartment() {
        return reportedDepartment;
    }

    public void setReportedDepartment(String reportedDepartment) {
        this.reportedDepartment = reportedDepartment;
    }

    @Override
    public SupportType getType() {
        return SupportType.COMPLAINT;
    }

    @Override
    public String getHandlingInstructions() {
        return "Review complaint related to department: " + reportedDepartment;
    }
}

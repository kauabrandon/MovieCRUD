package unifacisa.project.library.model;

import unifacisa.project.library.model.enums.PriorityLevel;
import unifacisa.project.library.model.enums.SupportStatus;
import unifacisa.project.library.model.enums.SupportType;

import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Support {
    private Long id;
    private User requester;
    private String subject;
    private String description;
    private SupportStatus status;
    private PriorityLevel priorityLevel;
    private LocalDateTime openedAt;
    private LocalDateTime closedAt;

    protected Support(Long id, User requester, String subject, String description, PriorityLevel priorityLevel) {
        this.id = id;
        this.requester = requester;
        this.subject = subject;
        this.description = description;
        this.priorityLevel = priorityLevel;
        this.openedAt = LocalDateTime.now();
        this.status = SupportStatus.OPEN;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getRequester() {
        return requester;
    }

    public void setRequester(User requester) {
        this.requester = requester;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SupportStatus getStatus() {
        return status;
    }

    public void setStatus(SupportStatus status) {
        this.status = status;
    }

    public PriorityLevel getPriorityLevel() {
        return priorityLevel;
    }

    public void setPriorityLevel(PriorityLevel priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    public LocalDateTime getOpenedAt() {
        return openedAt;
    }

    public void setOpenedAt(LocalDateTime openedAt) {
        this.openedAt = openedAt;
    }

    public LocalDateTime getClosedAt() {
        return closedAt;
    }

    public void setClosedAt(LocalDateTime closedAt) {
        this.closedAt = closedAt;
    }

    public void startHandling() {
        this.status = SupportStatus.INPROGRESS;
    }

    public void resolve() {
        this.status = SupportStatus.RESOLVED;
    }

    public void close() {
        this.status = SupportStatus.CLOSED;
        this.closedAt = LocalDateTime.now();
    }

    public abstract SupportType getType();

    public abstract String getHandlingInstructions();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Support)) return false;
        Support support = (Support) o;
        return Objects.equals(id, support.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Support{" +
                "id=" + id +
                ", requester=" + requester +
                ", subject='" + subject + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", priorityLevel=" + priorityLevel +
                ", openedAt=" + openedAt +
                ", closedAt=" + closedAt +
                '}';
    }
}

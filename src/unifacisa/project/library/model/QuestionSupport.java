package unifacisa.project.library.model;

import unifacisa.project.library.model.enums.PriorityLevel;
import unifacisa.project.library.model.enums.SupportType;

public class QuestionSupport extends Support{
    private String topic;

    protected QuestionSupport(Long id, User requester, String subject, String description, PriorityLevel priorityLevel, String topic) {
        super(id, requester, subject, description, priorityLevel);
        this.topic = topic;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    @Override
    public SupportType getType() {
        return SupportType.QUESTION;
    }

    @Override
    public String getHandlingInstructions() {
        return "Clarify the users question about: " + topic;
    }
}

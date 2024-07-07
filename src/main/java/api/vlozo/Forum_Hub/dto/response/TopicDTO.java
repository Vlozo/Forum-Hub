package api.vlozo.Forum_Hub.dto.response;

import api.vlozo.Forum_Hub.domain.Topic;
import api.vlozo.Forum_Hub.domain.TopicStatus;

import java.time.LocalDate;

public record TopicDTO(
        Long id,
        String title,
        String message,
        TopicStatus status,
        CourseDTO course,
        String author,
        LocalDate createdDate
) {
    public TopicDTO(Topic topic){
        this(topic.getId(), topic.getTitle(), topic.getMessage(), topic.getTopicStatus(), new CourseDTO(topic.getCourse()), topic.getAuthor().getUsername(), topic.getCreatedDate());
    }
}

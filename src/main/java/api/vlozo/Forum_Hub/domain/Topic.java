package api.vlozo.Forum_Hub.domain;

import java.time.LocalDateTime;
import java.util.List;

public class Topic {
    private Long id;
    private String title;
    private String message;
    private LocalDateTime createdDate;
    private TopicStatus status;
    private User author;
    private Course course;
    private List<Answer> answers;

}

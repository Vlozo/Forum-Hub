package api.vlozo.Forum_Hub.domain;

import java.time.LocalDateTime;

public class Answer {
    private Long id;
    private String message;
    private Topic topic;
    private LocalDateTime createdDate;
    private User author;
    private boolean solution;
}

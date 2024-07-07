package api.vlozo.Forum_Hub.domain;

import api.vlozo.Forum_Hub.dto.request.CreateTopicDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "topics")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String message;
    private LocalDate createdDate;

    @Enumerated(EnumType.STRING)
    private TopicStatus topicStatus;

    @Setter
    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    @Setter
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @Transient
    private List<Answer> answers;


    public Topic(CreateTopicDTO data, Course course, User author) {
        this.title = data.title();
        this.message = data.message();
        this.course = course;
        this.author = author;
        this.topicStatus = TopicStatus.OPEN;
        this.createdDate = LocalDate.now();
    }
}

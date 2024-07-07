package api.vlozo.Forum_Hub.domain;

import api.vlozo.Forum_Hub.dto.request.CreateCourseDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="courses")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String category;

    @OneToMany(mappedBy = "course")
    private List<Topic> topics = new ArrayList<>();

    public Course(CreateCourseDTO data) {
        this.name = data.name();
        this.category = data.category();
    }
}

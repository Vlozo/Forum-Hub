package api.vlozo.Forum_Hub.dto.response;

import api.vlozo.Forum_Hub.domain.Course;

public record CourseDTO(
        Long id,
        String name,
        String category
) {
    public CourseDTO(Course course){
        this(course.getId(), course.getName(), course.getCategory());
    }
}

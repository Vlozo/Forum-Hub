package api.vlozo.Forum_Hub.repository;

import api.vlozo.Forum_Hub.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {
}

package api.vlozo.Forum_Hub.repository;

import api.vlozo.Forum_Hub.domain.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Long> {
    boolean existsByTitleAndMessage(String title, String message);
}

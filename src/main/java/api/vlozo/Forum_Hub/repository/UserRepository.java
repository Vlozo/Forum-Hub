package api.vlozo.Forum_Hub.repository;

import api.vlozo.Forum_Hub.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

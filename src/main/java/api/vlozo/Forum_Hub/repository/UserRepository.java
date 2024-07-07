package api.vlozo.Forum_Hub.repository;

import api.vlozo.Forum_Hub.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, Long> {

    UserDetails findByUsername(String username);

    User getReferenceByUsername(String username);
}

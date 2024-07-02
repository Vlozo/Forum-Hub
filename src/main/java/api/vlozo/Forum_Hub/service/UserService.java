package api.vlozo.Forum_Hub.service;

import api.vlozo.Forum_Hub.domain.User;
import api.vlozo.Forum_Hub.dto.request.RegisterUserDTO;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public User registerUser(RegisterUserDTO dto){
        var encoder = new BCryptPasswordEncoder();
        var encodedPassword = encoder.encode(dto.password());

        var user = new User();
        user.setUsername(dto.username());
        user.setEmail(dto.email());
        user.setPassword(encodedPassword);
        user.setActive(true);

        return user;
    }
}

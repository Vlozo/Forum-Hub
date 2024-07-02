package api.vlozo.Forum_Hub.dto.response;

import api.vlozo.Forum_Hub.domain.User;

public record UserDTO(
        Long id,
        String username,
        String email
) {
    public UserDTO(User user){
        this(user.getId(), user.getUsername(), user.getEmail());
    }
}

package api.vlozo.Forum_Hub.dto.request;

import jakarta.validation.constraints.NotBlank;

public record AuthenticationDTO(
        @NotBlank
        String username,
        @NotBlank
        String password
) {
}

package api.vlozo.Forum_Hub.dto.request;

import jakarta.validation.constraints.NotBlank;

public record CreateCourseDTO(
        @NotBlank
        String name,
        @NotBlank
        String category
) {
}

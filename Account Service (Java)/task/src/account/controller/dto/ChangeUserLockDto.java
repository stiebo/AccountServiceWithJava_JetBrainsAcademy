package account.controller.dto;

import jakarta.validation.constraints.NotBlank;

public record ChangeUserLockDto (
        @NotBlank
        String user,
        @NotBlank
        String operation) {}

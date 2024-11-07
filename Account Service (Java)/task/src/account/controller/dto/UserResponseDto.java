package account.controller.dto;

import java.util.List;

public record UserResponseDto(Long id, String name, String lastname, String email, List<String> roles) {}
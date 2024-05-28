package br.com.occurrence.api.app.api.dto;

import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.UUID;

public record UserDto(
        UUID id,
        @Size(max = 80) String name,
        @Size(max = 80) String email,
        @Size(max = 40) String login,
        Status status,
        LocalDateTime createdAt,
        String createdBy,
        LocalDateTime updatedAt,
        String updatedBy) {

    public enum Status {
        ACTIVATED,
        INACTIVE,
        PENDING,
        BLOCKED,
        DELETED
    }
}

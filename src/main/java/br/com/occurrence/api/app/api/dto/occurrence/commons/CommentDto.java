package br.com.occurrence.api.app.api.dto.occurrence.commons;

import br.com.occurrence.api.app.api.dto.organization.UserDto;

import java.time.LocalDateTime;

public record CommentDto(
        String text,
        LocalDateTime date,
        UserDto user) {
}

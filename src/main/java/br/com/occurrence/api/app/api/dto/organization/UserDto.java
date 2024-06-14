package br.com.occurrence.api.app.api.dto.organization;

import br.com.occurrence.api.app.api.dto.organization.commons.ContactDto;

import java.util.UUID;

public record UserDto(
        UUID id,
        String name,
        String email,
        String login,
        Status status,
        TeamDto team,
        ContactDto contact) {

    public enum Status {
        ACTIVE,
        INACTIVE,
        BLOCKED,
        DELETED
    }
}

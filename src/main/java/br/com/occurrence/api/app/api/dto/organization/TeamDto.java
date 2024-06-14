package br.com.occurrence.api.app.api.dto.organization;

import br.com.occurrence.api.app.api.dto.organization.commons.ContactDto;

import java.util.List;
import java.util.UUID;

public record TeamDto(
        UUID id,
        String name,
        String description,
        UserDto responsible,
        ContactDto contact,
        SectorDto sector,
        List<UserDto> users,
        Status status) {

    public enum Status {
        ACTIVE,
        INACTIVE,
        DELETED
    }

}

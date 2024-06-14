package br.com.occurrence.api.app.api.dto.organization;

import br.com.occurrence.api.app.api.dto.organization.commons.ContactDto;

import java.util.List;
import java.util.UUID;

public record SectorDto(
        UUID id,
        String name,
        String description,
        UserDto responsible,
        ContactDto contact,
        DepartmentDto department,
        List<TeamDto> teams,
        Status status) {

    public enum Status {
        ACTIVE,
        INACTIVE,
        DELETED
    }

}
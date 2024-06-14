package br.com.occurrence.api.app.api.dto.organization;

import br.com.occurrence.api.app.api.dto.organization.commons.ContactDto;

import java.util.List;
import java.util.UUID;

public record DepartmentDto(
        UUID id,
        String name,
        String description,
        UserDto responsible,
        ContactDto contact,
        UnitDto unit,
        List<SectorDto> sectors,
        Status status) {

    public enum Status {
        ACTIVE,
        INACTIVE,
        DELETED;
    }

}
package br.com.occurrence.api.app.api.dto.organization;

import br.com.occurrence.api.app.api.dto.organization.commons.AddressDto;
import br.com.occurrence.api.app.api.dto.organization.commons.ContactDto;

import java.util.List;
import java.util.UUID;

public record UnitDto(
        UUID id,
        String name,
        String description,
        UserDto responsible,
        AddressDto address,
        ContactDto contact,
        List<DepartmentDto> departments,
        Status status) {

    public enum Status {
        ACTIVE,
        INACTIVE,
        DELETED
    }

}

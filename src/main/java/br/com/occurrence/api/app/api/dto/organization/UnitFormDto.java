package br.com.occurrence.api.app.api.dto.organization;

import br.com.occurrence.api.app.api.dto.organization.commons.AddressDto;
import br.com.occurrence.api.app.api.dto.organization.commons.ContactDto;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record UnitFormDto(
        @NotNull @Size(max = 80) String name,
        @Size(max = 80) String description,
        @NotNull UUID responsibleId,
        AddressDto address,
        ContactDto contact) {
}

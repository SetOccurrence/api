package br.com.occurrence.api.app.api.dto;

import br.com.occurrence.api.app.api.dto.commons.ContactDto;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record TeamFormDto(
        @Size(max = 80) String name,
        @Size(max = 80) String description,
        @NotNull UUID responsibleId,
        ContactDto contact) {
}

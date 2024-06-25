package br.com.occurrence.api.app.api.dto.occurrence;

import br.com.occurrence.api.app.api.dto.occurrence.commons.flow.FormRegistryDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record OccurrenceFormDto(@NotNull String occurrenceKindId, @NotNull @Valid FormRegistryDto registry) {
}

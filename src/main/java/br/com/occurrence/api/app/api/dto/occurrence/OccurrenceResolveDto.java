package br.com.occurrence.api.app.api.dto.occurrence;

import br.com.occurrence.api.app.api.dto.occurrence.commons.flow.FlowRegistryDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record OccurrenceResolveDto(@NotNull @Valid FlowRegistryDto registry) {
}

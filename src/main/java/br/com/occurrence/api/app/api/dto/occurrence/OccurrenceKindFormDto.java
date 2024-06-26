package br.com.occurrence.api.app.api.dto.occurrence;

import br.com.occurrence.api.app.api.dto.occurrence.commons.flow.FlowMapDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record OccurrenceKindFormDto(
        @NotBlank String name,
        @NotBlank String icon,
        @NotBlank String color,
        @NotBlank String prefix,
        String description,
        @NotBlank String category,
        @Valid @NotNull FlowMapDto flowMap) {
}

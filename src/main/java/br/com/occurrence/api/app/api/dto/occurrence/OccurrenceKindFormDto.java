package br.com.occurrence.api.app.api.dto.occurrence;

import br.com.occurrence.api.app.api.dto.occurrence.commons.flow.FlowMapDto;

public record OccurrenceKindFormDto(
        String name,
        String prefix,
        String description,
        String category,
        FlowMapDto flowMap) {
}

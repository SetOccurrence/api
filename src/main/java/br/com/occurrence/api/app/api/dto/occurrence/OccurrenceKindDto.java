package br.com.occurrence.api.app.api.dto.occurrence;

import br.com.occurrence.api.app.api.dto.occurrence.commons.flow.FlowMapDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

public record OccurrenceKindDto(
        String id,
        String name,
        String prefix,
        String description,
        String category,
        Status status,
        FlowMapDto flowMap) {

    @Getter
    @AllArgsConstructor
    public enum Status {
        ACTIVE("Active"),
        INACTIVE("Inactive"),
        DELETED("Deleted");

        private final String description;
    }

}


package br.com.occurrence.api.app.api.dto.occurrence;

import br.com.occurrence.api.app.api.dto.occurrence.commons.flow.FlowMapDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

public record OccurrenceKindDto(
        String id,
        String name,
        String icon,
        String color,
        String prefix,
        long instances,
        String description,
        String category,
        Status status,
        FlowMapDto flowMap,
        String createdBy,
        LocalDateTime createdAt) {

    @Getter
    @AllArgsConstructor
    public enum Status {
        ACTIVE("Active"),
        INACTIVE("Inactive"),
        DELETED("Deleted");

        private final String description;
    }

}


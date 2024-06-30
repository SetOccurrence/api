package br.com.occurrence.api.domain.util.filter;

import java.time.LocalDateTime;
import java.util.UUID;

public record OccurrenceFilter(
        String search,
        Boolean pending,
        Boolean myOccurrences,
        UUID requesterId,
        LocalDateTime startDateAt,
        LocalDateTime endDateAt) {
}

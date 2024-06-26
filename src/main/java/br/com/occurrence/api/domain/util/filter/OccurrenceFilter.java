package br.com.occurrence.api.domain.util.filter;

import java.time.LocalDateTime;
import java.util.UUID;

public record OccurrenceFilter(
        String search,
        boolean pending,
        boolean myOccurrences,
        UUID requesterId,
        LocalDateTime startDateAt,
        LocalDateTime endDateAt) {
}

package br.com.occurrence.api.domain.util.filter;

import java.time.LocalDateTime;

public record OccurrenceFilter(
        String search,
        boolean pending,
        boolean myOccurrences,
        LocalDateTime startDateAt,
        LocalDateTime endDateAt) {
}

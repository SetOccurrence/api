package br.com.occurrence.api.app.api.dto.occurrence;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record OccurrenceFormDto(@NotNull UUID occurrenceKindId) {
}

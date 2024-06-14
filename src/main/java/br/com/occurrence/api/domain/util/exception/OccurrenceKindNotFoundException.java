package br.com.occurrence.api.domain.util.exception;

import java.util.UUID;

public class OccurrenceKindNotFoundException extends RuntimeException {

    public static final String MESSAGE = "occurrence kind not found";

    public OccurrenceKindNotFoundException() {
        super(MESSAGE);
    }

    public OccurrenceKindNotFoundException(UUID id) {
        super(String.format("occurrence kind '%s' not found", id.toString()));
    }

    public OccurrenceKindNotFoundException(String message) {
        super(message);
    }

}

package br.com.occurrence.api.domain.util.exception;

import java.util.UUID;

public class OccurrenceNotFoundException extends RuntimeException {

    public static final String MESSAGE = "occurrence not found";

    public OccurrenceNotFoundException() {
        super(MESSAGE);
    }

    public OccurrenceNotFoundException(UUID id) {
        super(String.format("occurrence '%s' not found", id.toString()));
    }

    public OccurrenceNotFoundException(String message) {
        super(message);
    }

}

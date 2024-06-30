package br.com.occurrence.api.domain.util.exception;

public class OccurrenceAlreadyResolvedException extends RuntimeException {

    public static final String MESSAGE = "Ocorrencia já resolvida";

    public OccurrenceAlreadyResolvedException() {
        super(MESSAGE);
    }

    public OccurrenceAlreadyResolvedException(String message) {
        super(message);
    }

}

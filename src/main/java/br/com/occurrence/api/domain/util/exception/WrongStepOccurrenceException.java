package br.com.occurrence.api.domain.util.exception;

public class WrongStepOccurrenceException extends RuntimeException {

    public static final String MESSAGE = "Etapa de registro não condiz com etapa cadastrada";

    public WrongStepOccurrenceException() {
        super(MESSAGE);
    }

    public WrongStepOccurrenceException(String message) {
        super(message);
    }

}

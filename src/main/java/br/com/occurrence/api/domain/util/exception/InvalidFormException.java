package br.com.occurrence.api.domain.util.exception;

public class InvalidFormException extends RuntimeException {

    public static final String MESSAGE = "Problema no formulario da etap";

    public InvalidFormException() {
        super(MESSAGE);
    }

    public InvalidFormException(String message) {
        super(message);
    }

}

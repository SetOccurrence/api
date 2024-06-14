package br.com.occurrence.api.domain.util.exception;

public class UserAlreadyExistsException extends RuntimeException {

    public static final String MESSAGE = "Usuário já existe";

    public UserAlreadyExistsException() {
        super(MESSAGE);
    }

}
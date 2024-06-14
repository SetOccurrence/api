package br.com.occurrence.api.infrastructure.mongodb.entity.commons;

public abstract class Step {

    private String name;
    private String description;
    private Responsible responsible;

    public abstract Type getType();

    public enum Type {
        AUTHORIZATION,
        FORM
    }

}

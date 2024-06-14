package br.com.occurrence.api.domain.model.occurrence.commons.step;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Step {

    protected String name;
    protected String description;

    public abstract Type getType();

    public enum Type {
        AUTHORIZATION,
        FORM
    }

}

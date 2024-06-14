package br.com.occurrence.api.app.api.dto.occurrence.commons.step;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class StepDto {

    protected String name;
    protected String description;

    public abstract Type getType();

    public enum Type {
        AUTHORIZATION,
        FORM
    }

}

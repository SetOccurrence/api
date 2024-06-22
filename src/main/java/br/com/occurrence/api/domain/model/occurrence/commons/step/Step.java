package br.com.occurrence.api.domain.model.occurrence.commons.step;

import br.com.occurrence.api.domain.model.organization.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Step {

    protected String name;
    protected String description;
    protected Entity entity;

    public abstract Type getType();

    public enum Type {
        AUTHORIZATION,
        FORM
    }

}

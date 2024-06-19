package br.com.occurrence.api.app.api.dto.occurrence.commons.step;

import br.com.occurrence.api.app.api.dto.organization.commons.EntityDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class StepDto {

    protected String name;
    protected String description;
    protected EntityDto entityDto;

    public abstract Type getType();

    public enum Type {
        AUTHORIZATION,
        FORM
    }

}

package br.com.occurrence.api.app.api.dto.occurrence.commons.step;

import br.com.occurrence.api.app.api.dto.organization.commons.EntityDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class StepDto {

    @NotBlank
    protected String name;

    protected String description;

    @NotNull
    protected EntityDto entityDto;

    public abstract Type getType();

    public enum Type {
        AUTHORIZATION,
        FORM
    }

}

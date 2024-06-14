package br.com.occurrence.api.app.api.dto.occurrence.commons.flow;

import br.com.occurrence.api.app.api.dto.occurrence.commons.step.StepDto;
import br.com.occurrence.api.app.api.dto.organization.UserDto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public abstract class FlowRegistryDto {

    protected StepDto step;
    protected UserDto resolver;
    protected LocalDateTime resolvedAt;

}

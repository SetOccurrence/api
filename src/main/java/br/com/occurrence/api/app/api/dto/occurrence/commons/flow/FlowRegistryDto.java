package br.com.occurrence.api.app.api.dto.occurrence.commons.flow;

import br.com.occurrence.api.app.api.dto.occurrence.commons.step.StepDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class FlowRegistryDto {

    protected StepDto step;

}

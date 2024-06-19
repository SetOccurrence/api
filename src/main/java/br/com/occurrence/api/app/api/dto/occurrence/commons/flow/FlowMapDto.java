package br.com.occurrence.api.app.api.dto.occurrence.commons.flow;

import br.com.occurrence.api.app.api.dto.occurrence.commons.step.StepDto;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record FlowMapDto(@NotNull @NotEmpty List<StepDto> steps) {
}
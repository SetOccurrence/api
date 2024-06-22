package br.com.occurrence.api.app.api.dto.occurrence.commons.flow;

import br.com.occurrence.api.app.api.dto.occurrence.commons.step.StepDto;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.LinkedList;

public record FlowMapDto(@NotNull @NotEmpty LinkedList<StepDto> steps) {
}
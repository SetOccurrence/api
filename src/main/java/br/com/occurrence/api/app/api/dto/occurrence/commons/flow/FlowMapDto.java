package br.com.occurrence.api.app.api.dto.occurrence.commons.flow;

import br.com.occurrence.api.app.api.dto.occurrence.commons.step.StepDto;

import java.util.List;

public record FlowMapDto(List<StepDto> steps) {
}
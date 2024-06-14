package br.com.occurrence.api.app.api.dto.occurrence.commons.flow;

import java.util.List;

public record FlowDto(List<FlowRegistryDto> registries, int stepIndex) {
}

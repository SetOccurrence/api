package br.com.occurrence.api.app.api.dto.occurrence;

import br.com.occurrence.api.app.api.dto.occurrence.commons.CommentDto;
import br.com.occurrence.api.app.api.dto.occurrence.commons.flow.FlowDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

public record OccurrenceDto(
        UUID id,
        String name,
        OccurrenceKindDto occurrenceKind,
        OccurrenceDto.Status status,
        FlowDto flow,
        List<CommentDto> comments) {

    @Getter
    @AllArgsConstructor
    public enum Status {
        OPEN("Open"),
        CANCELED("Canceled"),
        FINISH("Finish");

        private final String description;
    }
}

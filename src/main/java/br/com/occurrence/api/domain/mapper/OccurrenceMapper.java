package br.com.occurrence.api.domain.mapper;

import br.com.occurrence.api.app.api.dto.occurrence.OccurrenceDto;
import br.com.occurrence.api.app.api.dto.occurrence.commons.CommentDto;
import br.com.occurrence.api.app.api.dto.occurrence.commons.flow.AuthorizationRegistryDto;
import br.com.occurrence.api.app.api.dto.occurrence.commons.flow.FlowDto;
import br.com.occurrence.api.app.api.dto.occurrence.commons.flow.FlowRegistryDto;
import br.com.occurrence.api.app.api.dto.occurrence.commons.flow.FormRegistryDto;
import br.com.occurrence.api.app.api.dto.occurrence.commons.form.answer.*;
import br.com.occurrence.api.domain.model.occurrence.Occurrence;
import br.com.occurrence.api.domain.model.occurrence.commons.Comment;
import br.com.occurrence.api.domain.model.occurrence.commons.flow.AuthorizationRegistry;
import br.com.occurrence.api.domain.model.occurrence.commons.flow.Flow;
import br.com.occurrence.api.domain.model.occurrence.commons.flow.FlowRegistry;
import br.com.occurrence.api.domain.model.occurrence.commons.flow.FormRegistry;
import br.com.occurrence.api.domain.model.occurrence.commons.form.answer.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class OccurrenceMapper {

    private final OccurrenceKindMapper occurrenceKindMapper;

    public OccurrenceDto toOccurrenceDto(Occurrence occurrence) {
        return new OccurrenceDto(
            occurrence.getId(),
            occurrence.getName(),
            occurrenceKindMapper.toOccurrenceKindDto(occurrence.getOccurrenceKind()),
            OccurrenceDto.Status.valueOf(occurrence.getStatus().name()),
            toFlowDto(occurrence.getFlow()),
            toCommentDto(occurrence.getComments()),
            occurrence.getCreatedBy(),
            occurrence.getCreatedAt()
        );
    }

    public FlowDto toFlowDto(Flow flow) {
        if (flow == null) {
            return null;
        }
        return new FlowDto(
            toFlowRegistryDto(flow.getRegistries()),
            flow.getStepIndex()
        );
    }

    public List<FlowRegistryDto> toFlowRegistryDto(List<FlowRegistry> flowRegistries) {
        if (flowRegistries == null) {
            return null;
        }
        return flowRegistries.stream()
                .map(this::toFlowRegistryDto)
                .toList();
    }

    public FlowRegistryDto toFlowRegistryDto(FlowRegistry flowRegistry) {
        if (flowRegistry == null) {
            return null;
        }
        return switch (flowRegistry.getType()) {
            case AUTHORIZATION -> toAuthorizationRegistryDto((AuthorizationRegistry) flowRegistry);
            case FORM -> toFormRegistryDto((FormRegistry) flowRegistry);
        };
    }

    public AuthorizationRegistryDto toAuthorizationRegistryDto(AuthorizationRegistry registry) {
        AuthorizationRegistryDto dto = new AuthorizationRegistryDto();
        dto.setStep(occurrenceKindMapper.toStepDto(registry.getStep()));
        dto.setResolver(UserMapper.toUserDTO(registry.getResolver()));
        dto.setResolvedAt(registry.getResolvedAt());
        dto.setAction(AuthorizationRegistryDto.Action.valueOf(registry.getAction().name()));
        dto.setObservation(registry.getObservation());
        return dto;
    }

    public FormRegistryDto toFormRegistryDto(FormRegistry registry) {
        FormRegistryDto dto = new FormRegistryDto();
        dto.setStep(occurrenceKindMapper.toStepDto(registry.getStep()));
        dto.setResolver(UserMapper.toUserDTO(registry.getResolver()));
        dto.setResolvedAt(registry.getResolvedAt());
        dto.setAnswers(AnswerMapper.toAnswerDto(registry.getAnswers()));
        return dto;
    }

    public static List<CommentDto> toCommentDto(List<Comment> comments) {
        if (comments == null) {
            return null;
        }
        return comments.stream()
                .map(OccurrenceMapper::toCommentDto)
                .toList();
    }

    public static CommentDto toCommentDto(Comment comment) {
        if (comment == null) {
            return null;
        }
        return new CommentDto(
            comment.getText(),
            comment.getDate(),
            UserMapper.toUserDTO(comment.getUser())
        );
    }


    //void updateOccurrenceFromDto(@MappingTarget Occurrence occurrence, OccurrenceFormDto form);

}

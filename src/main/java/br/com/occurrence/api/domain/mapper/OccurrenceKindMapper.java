package br.com.occurrence.api.domain.mapper;

import br.com.occurrence.api.app.api.dto.occurrence.OccurrenceKindFormDto;
import br.com.occurrence.api.domain.model.occurrence.OccurrenceKind;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OccurrenceKindMapper {

    //OccurrenceKind toOccurrenceKind(OccurrenceKindFormDto form);
    //OccurrenceKindDto toOccurrenceKindDto(OccurrenceKind occurrenceKind);
    //void updateOccurrenceKindFromDto(@MappingTarget OccurrenceKind occurrenceKind, OccurrenceKindFormDto form);

}

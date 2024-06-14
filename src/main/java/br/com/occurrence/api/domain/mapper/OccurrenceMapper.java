package br.com.occurrence.api.domain.mapper;

import br.com.occurrence.api.app.api.dto.occurrence.OccurrenceDto;
import br.com.occurrence.api.app.api.dto.occurrence.OccurrenceFormDto;
import br.com.occurrence.api.domain.model.occurrence.Occurrence;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OccurrenceMapper {

    //Occurrence toOccurrence(OccurrenceFormDto form);
    //OccurrenceDto toOccurrenceDto(Occurrence occurrence);
    void updateOccurrenceFromDto(@MappingTarget Occurrence occurrence, OccurrenceFormDto form);

}

package br.com.occurrence.api.domain.mapper;

import br.com.occurrence.api.app.api.dto.occurrence.OccurrenceFormDto;
import br.com.occurrence.api.domain.model.occurrence.Occurrence;
import br.com.occurrence.api.domain.service.OccurrenceKindService;
import br.com.occurrence.api.domain.service.OccurrenceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class OccurrenceMapper {
    
    public Occurrence toOccurrence(OccurrenceFormDto form) {
        return null;
    }

    //OccurrenceDto toOccurrenceDto(Occurrence occurrence);
    //void updateOccurrenceFromDto(@MappingTarget Occurrence occurrence, OccurrenceFormDto form);

}

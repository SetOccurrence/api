package br.com.occurrence.api.infrastructure.adapter.mapper;

import br.com.occurrence.api.domain.model.occurrence.Occurrence;
import br.com.occurrence.api.domain.service.OccurrenceKindService;
import br.com.occurrence.api.domain.util.exception.OccurrenceKindNotFoundException;
import br.com.occurrence.api.domain.util.filter.OccurrenceFilter;
import br.com.occurrence.api.infrastructure.mongodb.entity.OccurrenceEntity;
import br.com.occurrence.api.infrastructure.mongodb.specification.OccurrenceEntityCriteria;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class OccurrenceEntityMapper {

    private final OccurrenceKindService occurrenceKindService;

    public static OccurrenceEntity toOccurrenceEntity(Occurrence occurrence) {
        OccurrenceEntity entity = new OccurrenceEntity();
        entity.setId(occurrence.getId());
        entity.setName(occurrence.getName());
        entity.setStatus(occurrence.getStatus());
        entity.setOccurrenceKindId(occurrence.getOccurrenceKind().getId());
        entity.setFlow(occurrence.getFlow());
        entity.setComments(occurrence.getComments());
        entity.setCreatedBy(occurrence.getCreatedBy());
        entity.setCreatedAt(occurrence.getCreatedAt());
        return entity;
    }

    public Occurrence toOccurrence(OccurrenceEntity entity) {
        Occurrence occurrence = new Occurrence();
        occurrence.setId(entity.getId());
        occurrence.setName(entity.getName());
        occurrence.setStatus(entity.getStatus());
        try {
            occurrence.setOccurrenceKind(occurrenceKindService.findById(entity.getOccurrenceKindId()));
        } catch (OccurrenceKindNotFoundException e) {
            occurrence.setOccurrenceKind(null);
        }
        occurrence.setFlow(entity.getFlow());
        occurrence.setComments(entity.getComments());
        occurrence.setCreatedBy(entity.getCreatedBy());
        occurrence.setCreatedAt(entity.getCreatedAt());
        return occurrence;
    }

    public static OccurrenceEntityCriteria map(OccurrenceFilter filter) {
        if (filter == null) {
            return new OccurrenceEntityCriteria();
        }
        OccurrenceEntityCriteria criteria = new OccurrenceEntityCriteria();
        criteria.setSearch(filter.search());
        criteria.setPending(filter.pending());
        criteria.setMyOccurrences(filter.myOccurrences());
        criteria.setRequesterId(filter.requesterId());
        criteria.setStartDateAt(filter.startDateAt());
        criteria.setEndDateAt(filter.endDateAt());
        return criteria;
    }

}

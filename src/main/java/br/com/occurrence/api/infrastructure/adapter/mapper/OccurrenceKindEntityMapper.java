package br.com.occurrence.api.infrastructure.adapter.mapper;

import br.com.occurrence.api.domain.model.occurrence.OccurrenceKind;
import br.com.occurrence.api.domain.util.filter.OccurrenceKindFilter;
import br.com.occurrence.api.infrastructure.mongodb.entity.OccurrenceKindEntity;
import br.com.occurrence.api.infrastructure.mongodb.specification.OccurrenceKindEntityCriteria;

public class OccurrenceKindEntityMapper {

    public static OccurrenceKindEntity toOccurrenceKindEntity(OccurrenceKind occurrenceKind) {
        OccurrenceKindEntity entity = new OccurrenceKindEntity();
        entity.setId(occurrenceKind.getId());
        entity.setName(occurrenceKind.getName());
        entity.setPrefix(occurrenceKind.getPrefix());
        entity.setDescription(occurrenceKind.getDescription());
        entity.setCategory(occurrenceKind.getCategory());
        entity.setStatus(occurrenceKind.getStatus());
        entity.setFlowMap(occurrenceKind.getFlowMap());
        return entity;
    }

    public static OccurrenceKind toOccurrenceKind(OccurrenceKindEntity entity) {
        OccurrenceKind occurrenceKind = new OccurrenceKind();
        occurrenceKind.setId(entity.getId());
        occurrenceKind.setName(entity.getName());
        occurrenceKind.setPrefix(entity.getPrefix());
        occurrenceKind.setDescription(entity.getDescription());
        occurrenceKind.setCategory(entity.getCategory());
        occurrenceKind.setStatus(entity.getStatus());
        occurrenceKind.setFlowMap(entity.getFlowMap());
        return occurrenceKind;
    }

    public static OccurrenceKindEntityCriteria map(OccurrenceKindFilter filter) {
        OccurrenceKindEntityCriteria criteria = new OccurrenceKindEntityCriteria();
        criteria.setSearch(filter.search());
        return criteria;
    }

}

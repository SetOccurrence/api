package br.com.occurrence.api.infrastructure.adapter.mapper;

import br.com.occurrence.api.domain.model.Unit;
import br.com.occurrence.api.domain.util.filter.UnitFilter;
import br.com.occurrence.api.infrastructure.postgres.entity.UnitEntity;
import br.com.occurrence.api.infrastructure.postgres.specification.UnitSpecification;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UnitEntityMapper {

    UnitEntity toUnitEntity(Unit unit);
    Unit toUnit(UnitEntity entity);

    UnitSpecification map(UnitFilter unitFilter);

    Unit.Status map(UnitEntity.Status status);
    UnitEntity.Status map(Unit.Status status);

}

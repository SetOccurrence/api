package br.com.occurrence.api.domain.mapper;

import br.com.occurrence.api.app.api.dto.UnitDto;
import br.com.occurrence.api.app.api.dto.UnitFormDto;
import br.com.occurrence.api.domain.model.Unit;
import br.com.occurrence.api.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UnitMapper {

    Unit toUnit(UnitFormDto unitFormDTO);

    default Unit toUnit(UnitFormDto unitFormDTO, User responsible) {
        if (unitFormDTO == null) {
            return null;
        }
        Unit unit = toUnit(unitFormDTO);
        unit.setResponsible(responsible);
        return unit;
    }

    void updateUnitFromDTO(@MappingTarget Unit unit, UnitFormDto unitFormDTO);

    default void updateUnitFromDTO(@MappingTarget Unit unit, UnitFormDto unitFormDTO, User responsible) {
        if (unit == null) {
            return;
        }
        updateUnitFromDTO(unit, unitFormDTO);
        unit.setResponsible(responsible);
    }

    UnitDto toUnitDTO(Unit unit);

}

package br.com.occurrence.api.domain.mapper;

import br.com.occurrence.api.app.api.dto.organization.UnitDto;
import br.com.occurrence.api.app.api.dto.organization.UnitFormDto;
import br.com.occurrence.api.domain.model.organization.Unit;
import br.com.occurrence.api.domain.model.organization.User;
import br.com.occurrence.api.domain.util.PropertiesHelper;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UnitMapper {

    public static Unit toUnit(UnitFormDto unitFormDTO, User responsible) {
        if (unitFormDTO == null) {
            return null;
        }
        Unit unit = new Unit();
        unit.setName(unitFormDTO.name());
        unit.setDescription(unitFormDTO.description());
        unit.setAddress(AddressMapper.toAddress(unitFormDTO.address()));
        unit.setContact(ContactMapper.toContact(unitFormDTO.contact()));
        unit.setResponsible(responsible);
        return unit;
    }

    public static UnitDto toUnitDTO(Unit unit) {
        if (unit == null) {
            return null;
        }
        return new UnitDto(
            unit.getId(),
            unit.getName(),
            unit.getDescription(),
            UserMapper.toUserDTO(unit.getResponsible()),
            AddressMapper.toAddressDto(unit.getAddress()),
            ContactMapper.toContactDto(unit.getContact()),
            DepartmentMapper.toDepartmentDTO(unit.getDepartments()),
            UnitDto.Status.valueOf(unit.getStatus().name())
        );
    }

    public static void updateUnitFromDTO(Unit unit, UnitFormDto unitFormDTO, User responsible) {
        if (unit == null) {
            return;
        }
        PropertiesHelper.copyNonNullProperties(unitFormDTO, unit);
        unit.setResponsible(responsible);
    }

}

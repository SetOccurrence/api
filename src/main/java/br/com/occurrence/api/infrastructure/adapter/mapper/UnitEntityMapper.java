package br.com.occurrence.api.infrastructure.adapter.mapper;

import br.com.occurrence.api.domain.model.organization.Unit;
import br.com.occurrence.api.domain.util.filter.UnitFilter;
import br.com.occurrence.api.infrastructure.postgres.entity.UnitEntity;
import br.com.occurrence.api.infrastructure.postgres.specification.UnitSpecification;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UnitEntityMapper {

    public UnitEntity toUnitEntity(Unit unit) {
        if (unit == null) {
            return null;
        }
        UnitEntity entity = new UnitEntity();
        entity.setId(unit.getId());
        entity.setName(unit.getName());
        entity.setDescription(unit.getDescription());
        entity.setResponsible(UserEntityMapper.toUserEntity(unit.getResponsible()));
        entity.setAddress(AddressEntityMapper.toAddressEntity(unit.getAddress()));
        entity.setContact(ContactEntityMapper.toContactEntity(unit.getContact()));
        entity.setDepartments(DepartmentEntityMapper.toDepartmentEntityWithoutRelations(unit.getDepartments()));
        entity.setStatus(UnitEntity.Status.valueOf(unit.getStatus().name()));
        entity.setCreatedBy(unit.getCreatedBy());
        entity.setCreatedAt(unit.getCreatedAt());
        entity.setUpdatedBy(unit.getUpdatedBy());
        entity.setUpdatedAt(unit.getUpdatedAt());
        return entity;
    }

    public UnitEntity toUnitEntityWithoutRelations(Unit unit) {
        if (unit == null) {
            return null;
        }
        UnitEntity entity = new UnitEntity();
        entity.setId(unit.getId());
        entity.setName(unit.getName());
        entity.setDescription(unit.getDescription());
        entity.setAddress(AddressEntityMapper.toAddressEntity(unit.getAddress()));
        entity.setContact(ContactEntityMapper.toContactEntity(unit.getContact()));
        entity.setStatus(UnitEntity.Status.valueOf(unit.getStatus().name()));
        entity.setCreatedBy(unit.getCreatedBy());
        entity.setCreatedAt(unit.getCreatedAt());
        entity.setUpdatedBy(unit.getUpdatedBy());
        entity.setUpdatedAt(unit.getUpdatedAt());
        return entity;
    }

    public static Unit toUnit(UnitEntity entity) {
        if (entity == null) {
            return null;
        }
        Unit unit = new Unit();
        unit.setId(entity.getId());
        unit.setName(entity.getName());
        unit.setDescription(entity.getDescription());
        unit.setResponsible(UserEntityMapper.toUser(entity.getResponsible()));
        unit.setAddress(AddressEntityMapper.toAddress(entity.getAddress()));
        unit.setContact(ContactEntityMapper.toContact(entity.getContact()));
        unit.setDepartments(DepartmentEntityMapper.toDepartmentWithoutRelations(entity.getDepartments()));
        unit.setStatus(Unit.Status.valueOf(entity.getStatus().name()));
        unit.setCreatedBy(entity.getCreatedBy());
        unit.setCreatedAt(entity.getCreatedAt());
        unit.setUpdatedBy(entity.getUpdatedBy());
        unit.setUpdatedAt(entity.getUpdatedAt());
        return unit;
    }

    public static Unit toUnitWithoutRelations(UnitEntity entity) {
        if (entity == null) {
            return null;
        }
        Unit unit = new Unit();
        unit.setId(entity.getId());
        unit.setName(entity.getName());
        unit.setDescription(entity.getDescription());
        unit.setAddress(AddressEntityMapper.toAddress(entity.getAddress()));
        unit.setContact(ContactEntityMapper.toContact(entity.getContact()));
        unit.setStatus(Unit.Status.valueOf(entity.getStatus().name()));
        unit.setCreatedBy(entity.getCreatedBy());
        unit.setCreatedAt(entity.getCreatedAt());
        unit.setUpdatedBy(entity.getUpdatedBy());
        unit.setUpdatedAt(entity.getUpdatedAt());
        return unit;
    }

    public static UnitSpecification map(UnitFilter filter) {
        if (filter == null) {
            return null;
        }
        UnitSpecification specification = new UnitSpecification();
        specification.setName(filter.name());
        specification.setResponsibleId(filter.responsible() != null ? filter.responsible().id() : null);
        specification.setResponsibleName(filter.responsible() != null ? filter.responsible().name() : null);
        specification.setStatus(filter.status() != null ? UnitEntity.Status.valueOf(filter.status().name()) : null);
        return specification;
    }

}

package br.com.occurrence.api.infrastructure.adapter.mapper;

import br.com.occurrence.api.domain.model.organization.Department;
import br.com.occurrence.api.domain.model.organization.Sector;
import br.com.occurrence.api.domain.util.filter.DepartmentFilter;
import br.com.occurrence.api.infrastructure.postgres.entity.DepartmentEntity;
import br.com.occurrence.api.infrastructure.postgres.entity.SectorEntity;
import br.com.occurrence.api.infrastructure.postgres.specification.DepartmentSpecification;
import lombok.experimental.UtilityClass;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

@UtilityClass
public class DepartmentEntityMapper {

    public static DepartmentEntity toDepartmentEntity(Department department) {
        if (department == null) {
            return null;
        }
        DepartmentEntity entity = new DepartmentEntity();
        entity.setId(department.getId());
        entity.setName(department.getName());
        entity.setDescription(department.getDescription());
        entity.setResponsible(UserEntityMapper.toUserEntity(department.getResponsible()));
        entity.setContact(ContactEntityMapper.toContactEntity(department.getContact()));
        entity.setUnit(UnitEntityMapper.toUnitEntityWithoutRelations(department.getUnit()));
        entity.setSectors(SectorEntityMapper.toSectorEntityWithoutRelations(department.getSectors()));
        entity.setStatus(DepartmentEntity.Status.valueOf(department.getStatus().name()));
        entity.setCreatedBy(department.getCreatedBy());
        entity.setCreatedAt(department.getCreatedAt());
        entity.setUpdatedBy(department.getUpdatedBy());
        entity.setUpdatedAt(department.getUpdatedAt());
        return entity;
    }

    public static DepartmentEntity toDepartmentEntityWithoutRelations(Department department) {
        if (department == null) {
            return null;
        }
        DepartmentEntity entity = new DepartmentEntity();
        entity.setId(department.getId());
        entity.setName(department.getName());
        entity.setDescription(department.getDescription());
        entity.setContact(ContactEntityMapper.toContactEntity(department.getContact()));
        entity.setStatus(DepartmentEntity.Status.valueOf(department.getStatus().name()));
        entity.setCreatedBy(department.getCreatedBy());
        entity.setCreatedAt(department.getCreatedAt());
        entity.setUpdatedBy(department.getUpdatedBy());
        entity.setUpdatedAt(department.getUpdatedAt());
        return entity;
    }

    public static List<DepartmentEntity> toDepartmentEntity(List<Department> departments) {
        if (CollectionUtils.isEmpty(departments)) {
            return Collections.emptyList();
        }
        return departments.stream()
                .map(DepartmentEntityMapper::toDepartmentEntity)
                .toList();
    }

    public static List<DepartmentEntity> toDepartmentEntityWithoutRelations(List<Department> departments) {
        if (CollectionUtils.isEmpty(departments)) {
            return Collections.emptyList();
        }
        return departments.stream()
                .map(DepartmentEntityMapper::toDepartmentEntityWithoutRelations)
                .toList();
    }

    public static Department toDepartment(DepartmentEntity entity) {
        if (entity == null) {
            return null;
        }
        Department department = new Department();
        department.setId(entity.getId());
        department.setName(entity.getName());
        department.setDescription(entity.getDescription());
        department.setResponsible(UserEntityMapper.toUser(entity.getResponsible()));
        department.setContact(ContactEntityMapper.toContact(entity.getContact()));
        department.setUnit(UnitEntityMapper.toUnitWithoutRelations(entity.getUnit()));
        department.setSectors(SectorEntityMapper.toSectorWithoutRelations(entity.getSectors()));
        department.setStatus(Department.Status.valueOf(entity.getStatus().name()));
        department.setCreatedBy(entity.getCreatedBy());
        department.setCreatedAt(entity.getCreatedAt());
        department.setUpdatedBy(entity.getUpdatedBy());
        department.setUpdatedAt(entity.getUpdatedAt());
        return department;
    }

    public static Department toDepartmentWithoutRelations(DepartmentEntity entity) {
        if (entity == null) {
            return null;
        }
        Department department = new Department();
        department.setId(entity.getId());
        department.setName(entity.getName());
        department.setDescription(entity.getDescription());
        department.setContact(ContactEntityMapper.toContact(entity.getContact()));
        department.setStatus(Department.Status.valueOf(entity.getStatus().name()));
        department.setCreatedBy(entity.getCreatedBy());
        department.setCreatedAt(entity.getCreatedAt());
        department.setUpdatedBy(entity.getUpdatedBy());
        department.setUpdatedAt(entity.getUpdatedAt());
        return department;
    }

    public static List<Department> toDepartment(List<DepartmentEntity> entities) {
        if (CollectionUtils.isEmpty(entities)) {
            return Collections.emptyList();
        }
        return entities.stream()
                .map(DepartmentEntityMapper::toDepartment)
                .toList();
    }

    public static List<Department> toDepartmentWithoutRelations(List<DepartmentEntity> entities) {
        if (CollectionUtils.isEmpty(entities)) {
            return Collections.emptyList();
        }
        return entities.stream()
                .map(DepartmentEntityMapper::toDepartmentWithoutRelations)
                .toList();
    }

    public static DepartmentSpecification map(DepartmentFilter filter) {
        if (filter == null) {
            return null;
        }
        DepartmentSpecification specification = new DepartmentSpecification();
        specification.setName(filter.name());
        specification.setResponsibleId(filter.responsible() != null ? filter.responsible().id() : null);
        specification.setResponsibleName(filter.responsible() != null ? filter.responsible().name() : null);
        specification.setStatus(filter.status() != null ? DepartmentEntity.Status.valueOf(filter.status().name()) : null);
        return specification;
    }


}

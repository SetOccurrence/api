package br.com.occurrence.api.infrastructure.adapter.mapper;

import br.com.occurrence.api.domain.model.Department;
import br.com.occurrence.api.domain.util.filter.DepartmentFilter;
import br.com.occurrence.api.infrastructure.postgres.entity.DepartmentEntity;
import br.com.occurrence.api.infrastructure.postgres.specification.DepartmentSpecification;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DepartmentEntityMapper {

    DepartmentEntity toDepartmentEntity(Department department);
    Department toDepartment(DepartmentEntity entity);

    DepartmentSpecification map(DepartmentFilter departmentFilter);

    Department.Status map(DepartmentEntity.Status status);
    DepartmentEntity.Status map(Department.Status status);

}

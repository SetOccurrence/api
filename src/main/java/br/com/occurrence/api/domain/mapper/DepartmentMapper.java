package br.com.occurrence.api.domain.mapper;

import br.com.occurrence.api.app.api.dto.DepartmentDto;
import br.com.occurrence.api.app.api.dto.DepartmentFormDto;
import br.com.occurrence.api.domain.model.Department;
import br.com.occurrence.api.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DepartmentMapper {

    Department toDepartment(DepartmentFormDto departmentFormDTO);

    default Department toDepartment(DepartmentFormDto departmentFormDTO, User responsible) {
        if (departmentFormDTO == null) {
            return null;
        }
        Department department = toDepartment(departmentFormDTO);
        department.setResponsible(responsible);
        return department;
    }

    void updateDepartmentFromDTO(@MappingTarget Department department, DepartmentFormDto departmentFormDTO);

    default void updateDepartmentFromDTO(@MappingTarget Department department, DepartmentFormDto departmentFormDTO, User responsible) {
        if (department == null) {
            return;
        }
        updateDepartmentFromDTO(department, departmentFormDTO);
        department.setResponsible(responsible);
    }

    DepartmentDto toDepartmentDTO(Department department);

}

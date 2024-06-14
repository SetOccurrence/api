package br.com.occurrence.api.domain.mapper;

import br.com.occurrence.api.app.api.dto.organization.DepartmentDto;
import br.com.occurrence.api.app.api.dto.organization.DepartmentFormDto;
import br.com.occurrence.api.domain.model.organization.Department;
import br.com.occurrence.api.domain.model.organization.Unit;
import br.com.occurrence.api.domain.model.organization.User;
import br.com.occurrence.api.domain.util.PropertiesHelper;
import lombok.experimental.UtilityClass;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

@UtilityClass
public class DepartmentMapper {

    public static Department toDepartment(DepartmentFormDto departmentFormDTO, User responsible, Unit unit) {
        if (departmentFormDTO == null) {
            return null;
        }
        Department department = new Department();
        department.setName(departmentFormDTO.name());
        department.setDescription(departmentFormDTO.description());
        department.setContact(ContactMapper.toContact(departmentFormDTO.contact()));
        department.setResponsible(responsible);
        department.setUnit(unit);
        return department;
    }

    public static DepartmentDto toDepartmentDTO(Department department) {
        if (department == null) {
            return null;
        }
        return new DepartmentDto(
            department.getId(),
            department.getName(),
            department.getDescription(),
            UserMapper.toUserDTO(department.getResponsible()),
            ContactMapper.toContactDto(department.getContact()),
            UnitMapper.toUnitDTO(department.getUnit()),
            SectorMapper.toSectorDTO(department.getSectors()),
            DepartmentDto.Status.valueOf(department.getStatus().name())
        );
    }

    public static List<DepartmentDto> toDepartmentDTO(List<Department> departments) {
        if (CollectionUtils.isEmpty(departments)) {
            return Collections.emptyList();
        }
        return departments.stream()
                .map(DepartmentMapper::toDepartmentDTO)
                .toList();
    }

    public static void updateDepartmentFromDTO(Department department, DepartmentFormDto departmentFormDTO, User responsible, Unit unit) {
        if (department == null) {
            return;
        }
        PropertiesHelper.copyNonNullProperties(departmentFormDTO, department);
        if (responsible != null) {
            department.setResponsible(responsible);
        }
        if (unit != null) {
            department.setUnit(unit);
        }
    }

}

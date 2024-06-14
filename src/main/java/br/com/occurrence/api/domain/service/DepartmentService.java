package br.com.occurrence.api.domain.service;

import br.com.occurrence.api.app.api.dto.organization.DepartmentFormDto;
import br.com.occurrence.api.domain.mapper.DepartmentMapper;
import br.com.occurrence.api.domain.model.organization.Department;
import br.com.occurrence.api.domain.model.organization.Unit;
import br.com.occurrence.api.domain.model.organization.User;
import br.com.occurrence.api.domain.repository.DepartmentRepository;
import br.com.occurrence.api.domain.util.exception.DepartmentNotFoundException;
import br.com.occurrence.api.domain.util.filter.DepartmentFilter;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@AllArgsConstructor
@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final UserReadService userReadService;
    private final UnitService unitService;

    public Page<Department> findAll(Pageable pageable, DepartmentFilter filter) {
        return departmentRepository.findAll(pageable, filter);
    }

    public List<Department> findAll(DepartmentFilter filter) {
        return departmentRepository.findAll(filter);
    }

    public Department findById(UUID id) {
        return departmentRepository.findById(id)
                .orElseThrow(() -> new DepartmentNotFoundException(id));
    }

    public Department create(DepartmentFormDto departmentFormDTO) {
        User responsible = userReadService.findById(departmentFormDTO.responsibleId());
        Unit unit = unitService.findById(departmentFormDTO.unitId());
        Department department = DepartmentMapper.toDepartment(departmentFormDTO, responsible, unit);
        return departmentRepository.create(department);
    }

    public Department update(UUID id, DepartmentFormDto departmentFormDTO) {
        Department department = findById(id);
        User responsible = userReadService.findById(departmentFormDTO.responsibleId());
        Unit unit = unitService.findById(departmentFormDTO.unitId());
        DepartmentMapper.updateDepartmentFromDTO(department, departmentFormDTO, responsible, unit);
        return departmentRepository.update(department);
    }

    public Department inactivate(UUID id) {
        Department department = findById(id);
        department.setStatus(Department.Status.INACTIVE);
        return departmentRepository.update(department);
    }

    public Department logicallyDelete(UUID id) {
        Department department = findById(id);
        department.setStatus(Department.Status.DELETED);
        return departmentRepository.update(department);
    }

    public void deleteById(UUID id) {
        departmentRepository.deleteById(id);
    }

}

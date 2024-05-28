package br.com.occurrence.api.domain.service;

import br.com.occurrence.api.app.api.dto.DepartmentFormDto;
import br.com.occurrence.api.domain.mapper.DepartmentMapper;
import br.com.occurrence.api.domain.model.Department;
import br.com.occurrence.api.domain.model.User;
import br.com.occurrence.api.domain.repository.DepartmentRepository;
import br.com.occurrence.api.domain.util.exception.DepartmentNotFoundException;
import br.com.occurrence.api.domain.util.filter.DepartmentFilter;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@AllArgsConstructor
@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final UserService userService;
    private final DepartmentMapper departmentMapper;

    public Page<Department> findAll(Pageable pageable, DepartmentFilter filter) {
        return departmentRepository.findAll(pageable, filter);
    }

    public Department findById(UUID id) {
        return departmentRepository.findById(id)
                .orElseThrow(() -> new DepartmentNotFoundException(id));
    }

    public Department create(DepartmentFormDto departmentFormDTO) {
        User responsible = userService.findById(departmentFormDTO.responsibleId());
        Department department = departmentMapper.toDepartment(departmentFormDTO, responsible);
        return departmentRepository.create(department);
    }

    public Department update(UUID id, DepartmentFormDto departmentFormDTO) {
        Department department = findById(id);
        User responsible = userService.findById(departmentFormDTO.responsibleId());
        departmentMapper.updateDepartmentFromDTO(department, departmentFormDTO, responsible);
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

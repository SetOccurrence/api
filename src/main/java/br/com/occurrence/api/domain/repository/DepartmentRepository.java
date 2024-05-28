package br.com.occurrence.api.domain.repository;

import br.com.occurrence.api.domain.model.Department;
import br.com.occurrence.api.domain.util.filter.DepartmentFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DepartmentRepository {

    Page<Department> findAll(Pageable pageable, DepartmentFilter filter);
    List<Department> findAll(DepartmentFilter filter);
    Optional<Department> findById(UUID id);
    Department create(Department department);
    Department update(Department department);
    void deleteById(UUID id);

}

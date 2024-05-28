package br.com.occurrence.api.infrastructure.adapter;

import br.com.occurrence.api.domain.model.Department;
import br.com.occurrence.api.domain.repository.DepartmentRepository;
import br.com.occurrence.api.domain.util.filter.DepartmentFilter;
import br.com.occurrence.api.infrastructure.adapter.mapper.DepartmentEntityMapper;
import br.com.occurrence.api.infrastructure.postgres.entity.DepartmentEntity;
import br.com.occurrence.api.infrastructure.postgres.repository.DepartmentEntityRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Repository
public class DepartmentRepositoryAdapter implements DepartmentRepository {

    private final DepartmentEntityRepository departmentEntityRepository;
    private final DepartmentEntityMapper departmentEntityMapper;

    @Override
    public Page<Department> findAll(Pageable pageable, DepartmentFilter filter) {
        return departmentEntityRepository.findAll(departmentEntityMapper.map(filter), pageable)
                .map(departmentEntityMapper::toDepartment);
    }

    @Override
    public List<Department> findAll(DepartmentFilter filter) {
        return departmentEntityRepository.findAll(departmentEntityMapper.map(filter)).stream()
                .map(departmentEntityMapper::toDepartment)
                .toList();
    }

    @Override
    public Optional<Department> findById(UUID id) {
        return departmentEntityRepository.findById(id)
                .map(departmentEntityMapper::toDepartment);
    }

    @Override
    public Department create(Department department) {
        DepartmentEntity entity = departmentEntityMapper.toDepartmentEntity(department);
        entity = departmentEntityRepository.save(entity);
        return departmentEntityMapper.toDepartment(entity);
    }

    @Override
    public Department update(Department department) {
        DepartmentEntity entity = departmentEntityMapper.toDepartmentEntity(department);
        entity = departmentEntityRepository.save(entity);
        return departmentEntityMapper.toDepartment(entity);
    }

    @Override
    public void deleteById(UUID id) {
        departmentEntityRepository.deleteById(id);
    }

}

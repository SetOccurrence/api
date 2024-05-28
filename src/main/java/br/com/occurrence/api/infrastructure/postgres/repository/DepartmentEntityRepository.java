package br.com.occurrence.api.infrastructure.postgres.repository;

import br.com.occurrence.api.infrastructure.postgres.entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface DepartmentEntityRepository extends JpaRepository<DepartmentEntity, UUID>, JpaSpecificationExecutor<DepartmentEntity> {
}

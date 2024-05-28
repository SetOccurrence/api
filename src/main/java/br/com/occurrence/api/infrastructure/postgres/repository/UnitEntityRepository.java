package br.com.occurrence.api.infrastructure.postgres.repository;

import br.com.occurrence.api.infrastructure.postgres.entity.UnitEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface UnitEntityRepository extends JpaRepository<UnitEntity, UUID>, JpaSpecificationExecutor<UnitEntity> {
}

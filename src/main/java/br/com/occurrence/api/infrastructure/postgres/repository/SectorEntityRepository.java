package br.com.occurrence.api.infrastructure.postgres.repository;

import br.com.occurrence.api.infrastructure.postgres.entity.SectorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface SectorEntityRepository extends JpaRepository<SectorEntity, UUID>, JpaSpecificationExecutor<SectorEntity> {
}

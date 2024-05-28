package br.com.occurrence.api.infrastructure.postgres.repository;

import br.com.occurrence.api.infrastructure.postgres.entity.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface TeamEntityRepository extends JpaRepository<TeamEntity, UUID>, JpaSpecificationExecutor<TeamEntity> {
}

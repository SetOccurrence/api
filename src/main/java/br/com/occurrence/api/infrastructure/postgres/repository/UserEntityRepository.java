package br.com.occurrence.api.infrastructure.postgres.repository;

import br.com.occurrence.api.infrastructure.postgres.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface UserEntityRepository extends JpaRepository<UserEntity, UUID>, JpaSpecificationExecutor<UserEntity> {
}

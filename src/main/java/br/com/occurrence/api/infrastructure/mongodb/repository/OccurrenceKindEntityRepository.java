package br.com.occurrence.api.infrastructure.mongodb.repository;

import br.com.occurrence.api.infrastructure.mongodb.entity.OccurrenceKindEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface OccurrenceKindEntityRepository extends MongoRepository<OccurrenceKindEntity, UUID> {
}
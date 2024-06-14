package br.com.occurrence.api.infrastructure.mongodb.repository;

import br.com.occurrence.api.infrastructure.mongodb.entity.OccurrenceEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface OccurrenceEntityRepository extends MongoRepository<OccurrenceEntity, UUID> {
}

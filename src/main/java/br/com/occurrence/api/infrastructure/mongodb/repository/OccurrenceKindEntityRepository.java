package br.com.occurrence.api.infrastructure.mongodb.repository;

import br.com.occurrence.api.infrastructure.mongodb.entity.OccurrenceKindEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface OccurrenceKindEntityRepository extends MongoRepository<OccurrenceKindEntity, String> {
}
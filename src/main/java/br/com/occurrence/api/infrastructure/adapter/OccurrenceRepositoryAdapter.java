package br.com.occurrence.api.infrastructure.adapter;

import br.com.occurrence.api.domain.model.occurrence.Occurrence;
import br.com.occurrence.api.domain.model.occurrence.OccurrenceKind;
import br.com.occurrence.api.domain.repository.OccurrenceRepository;
import br.com.occurrence.api.domain.util.filter.OccurrenceFilter;
import br.com.occurrence.api.infrastructure.adapter.mapper.OccurrenceEntityMapper;
import br.com.occurrence.api.infrastructure.adapter.mapper.OccurrenceKindEntityMapper;
import br.com.occurrence.api.infrastructure.mongodb.entity.OccurrenceEntity;
import br.com.occurrence.api.infrastructure.mongodb.entity.OccurrenceKindEntity;
import br.com.occurrence.api.infrastructure.mongodb.repository.OccurrenceEntityRepository;
import br.com.occurrence.api.infrastructure.mongodb.specification.OccurrenceEntityCriteria;
import br.com.occurrence.api.infrastructure.mongodb.specification.OccurrenceKindEntityCriteria;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Component
public class OccurrenceRepositoryAdapter implements OccurrenceRepository {

    private final OccurrenceEntityRepository occurrenceEntityRepository;
    private final OccurrenceEntityMapper occurrenceEntityMapper;
    private final MongoTemplate mongoTemplate;

    @Override
    public Page<Occurrence> findAll(Pageable pageable, OccurrenceFilter filter) {
        OccurrenceEntityCriteria criteria = occurrenceEntityMapper.map(filter);
        Query query = criteria.getQuery();
        long count = mongoTemplate.count(criteria.getQuery(), OccurrenceEntity.class);
        query.with(pageable);
        List<Occurrence> occurrences = mongoTemplate.find(query, OccurrenceEntity.class).stream()
                .map(occurrenceEntityMapper::toOccurrence)
                .toList();
        return new PageImpl<>(occurrences, pageable, count);
    }

    @Override
    public List<Occurrence> findAll(OccurrenceFilter filter) {
        OccurrenceEntityCriteria criteria = OccurrenceEntityMapper.map(filter);
        return mongoTemplate.find(criteria.getQuery(), OccurrenceEntity.class).stream()
                .map(occurrenceEntityMapper::toOccurrence)
                .toList();
    }

    @Override
    public Optional<Occurrence> findById(String id) {
        return occurrenceEntityRepository.findById(id)
                .map(occurrenceEntityMapper::toOccurrence);
    }

    @Override
    public Occurrence create(Occurrence occurrence) {
        OccurrenceEntity entity = occurrenceEntityRepository.save(OccurrenceEntityMapper.toOccurrenceEntity(occurrence));
        return occurrenceEntityMapper.toOccurrence(entity);
    }

    @Override
    public Occurrence update(Occurrence occurrence) {
        OccurrenceEntity entity = occurrenceEntityRepository.save(OccurrenceEntityMapper.toOccurrenceEntity(occurrence));
        return occurrenceEntityMapper.toOccurrence(entity);
    }

    @Override
    public void deleteById(String id) {
        occurrenceEntityRepository.deleteById(id);
    }
}

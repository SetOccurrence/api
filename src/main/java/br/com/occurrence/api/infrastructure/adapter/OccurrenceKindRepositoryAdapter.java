package br.com.occurrence.api.infrastructure.adapter;

import br.com.occurrence.api.domain.model.occurrence.OccurrenceKind;
import br.com.occurrence.api.domain.repository.OccurrenceKindRepository;
import br.com.occurrence.api.domain.util.filter.OccurrenceKindFilter;
import br.com.occurrence.api.infrastructure.adapter.mapper.OccurrenceKindEntityMapper;
import br.com.occurrence.api.infrastructure.mongodb.entity.OccurrenceKindEntity;
import br.com.occurrence.api.infrastructure.mongodb.repository.OccurrenceKindEntityRepository;
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

@AllArgsConstructor
@Component
public class OccurrenceKindRepositoryAdapter implements OccurrenceKindRepository {

    private final OccurrenceKindEntityRepository occurrenceKindEntityRepository;
    private final MongoTemplate mongoTemplate;

    @Override
    public Page<OccurrenceKind> findAll(Pageable pageable, OccurrenceKindFilter filter) {
        OccurrenceKindEntityCriteria criteria = OccurrenceKindEntityMapper.map(filter);
        Query query = criteria.getQuery();
        long count = mongoTemplate.count(criteria.getQuery(), OccurrenceKindEntity.class);
        query.with(pageable);
        List<OccurrenceKind> occurrenceKinds = mongoTemplate.find(query, OccurrenceKindEntity.class).stream()
                .map(OccurrenceKindEntityMapper::toOccurrenceKind)
                .toList();
        return new PageImpl<>(occurrenceKinds, pageable, count);
    }

    @Override
    public List<OccurrenceKind> findAll(OccurrenceKindFilter filter) {
        OccurrenceKindEntityCriteria criteria = OccurrenceKindEntityMapper.map(filter);
        return mongoTemplate.find(criteria.getQuery(), OccurrenceKindEntity.class).stream()
                .map(OccurrenceKindEntityMapper::toOccurrenceKind)
                .toList();
    }

    @Override
    public Optional<OccurrenceKind> findById(String id) {
        return occurrenceKindEntityRepository.findById(id)
                .map(OccurrenceKindEntityMapper::toOccurrenceKind);
    }

    @Override
    public OccurrenceKind create(OccurrenceKind occurrenceKind) {
        OccurrenceKindEntity entity = OccurrenceKindEntityMapper.toOccurrenceKindEntity(occurrenceKind);
        return OccurrenceKindEntityMapper.toOccurrenceKind(occurrenceKindEntityRepository.save(entity));
    }

    @Override
    public OccurrenceKind update(OccurrenceKind occurrenceKind) {
        OccurrenceKindEntity entity = OccurrenceKindEntityMapper.toOccurrenceKindEntity(occurrenceKind);
        return OccurrenceKindEntityMapper.toOccurrenceKind(occurrenceKindEntityRepository.save(entity));
    }

    @Override
    public void deleteById(String id) {
        occurrenceKindEntityRepository.deleteById(id);
    }

}

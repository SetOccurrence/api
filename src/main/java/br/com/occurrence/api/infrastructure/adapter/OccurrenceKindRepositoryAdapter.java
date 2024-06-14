package br.com.occurrence.api.infrastructure.adapter;

import br.com.occurrence.api.domain.model.occurrence.OccurrenceKind;
import br.com.occurrence.api.domain.repository.OccurrenceKindRepository;
import br.com.occurrence.api.domain.util.filter.OccurrenceKindFilter;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Repository
public class OccurrenceKindRepositoryAdapter implements OccurrenceKindRepository {

    @Override
    public Page<OccurrenceKind> findAll(Pageable pageable, OccurrenceKindFilter filter) {
        return null;
    }

    @Override
    public List<OccurrenceKind> findAll(OccurrenceKindFilter filter) {
        return List.of();
    }

    @Override
    public Optional<OccurrenceKind> findById(UUID id) {
        return Optional.empty();
    }

    @Override
    public OccurrenceKind create(OccurrenceKind occurrenceKind) {
        return null;
    }

    @Override
    public OccurrenceKind update(OccurrenceKind occurrenceKind) {
        return null;
    }

    @Override
    public void deleteById(UUID id) {

    }
}

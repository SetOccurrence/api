package br.com.occurrence.api.infrastructure.adapter;

import br.com.occurrence.api.domain.model.occurrence.Occurrence;
import br.com.occurrence.api.domain.repository.OccurrenceRepository;
import br.com.occurrence.api.domain.util.filter.OccurrenceFilter;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Component
public class OccurrenceRepositoryAdapter implements OccurrenceRepository {

    @Override
    public Page<Occurrence> findAll(Pageable pageable, OccurrenceFilter filter) {
        return null;
    }

    @Override
    public List<Occurrence> findAll(OccurrenceFilter filter) {
        return List.of();
    }

    @Override
    public Optional<Occurrence> findById(UUID id) {
        return Optional.empty();
    }

    @Override
    public Occurrence create(Occurrence occurrence) {
        return null;
    }

    @Override
    public Occurrence update(Occurrence occurrence) {
        return null;
    }

    @Override
    public void deleteById(UUID id) {

    }
}

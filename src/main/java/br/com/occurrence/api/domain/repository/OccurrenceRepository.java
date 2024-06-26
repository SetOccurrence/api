package br.com.occurrence.api.domain.repository;

import br.com.occurrence.api.domain.model.occurrence.Occurrence;
import br.com.occurrence.api.domain.util.filter.OccurrenceFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface OccurrenceRepository {

    Page<Occurrence> findAll(Pageable pageable, OccurrenceFilter filter);
    List<Occurrence> findAll(OccurrenceFilter filter);
    Optional<Occurrence> findById(String id);
    Occurrence create(Occurrence occurrence);
    Occurrence update(Occurrence occurrence);
    void deleteById(String id);

}

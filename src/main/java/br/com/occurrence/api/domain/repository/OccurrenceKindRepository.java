package br.com.occurrence.api.domain.repository;

import br.com.occurrence.api.domain.model.occurrence.OccurrenceKind;
import br.com.occurrence.api.domain.util.filter.OccurrenceKindFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OccurrenceKindRepository {

    Page<OccurrenceKind> findAll(Pageable pageable, OccurrenceKindFilter filter);
    List<OccurrenceKind> findAll(OccurrenceKindFilter filter);
    Optional<OccurrenceKind> findById(String id);
    OccurrenceKind create(OccurrenceKind occurrenceKind);
    OccurrenceKind update(OccurrenceKind occurrenceKind);
    void deleteById(String id);

}

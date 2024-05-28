package br.com.occurrence.api.domain.repository;

import br.com.occurrence.api.domain.model.Unit;
import br.com.occurrence.api.domain.util.filter.UnitFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UnitRepository {

    Page<Unit> findAll(Pageable pageable, UnitFilter filter);
    List<Unit> findAll(UnitFilter filter);
    Optional<Unit> findById(UUID id);
    Unit create(Unit unit);
    Unit update(Unit unit);
    void deleteById(UUID id);

}

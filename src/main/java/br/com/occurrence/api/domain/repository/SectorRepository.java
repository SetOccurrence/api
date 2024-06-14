package br.com.occurrence.api.domain.repository;

import br.com.occurrence.api.domain.model.organization.Sector;
import br.com.occurrence.api.domain.util.filter.SectorFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SectorRepository {

    Page<Sector> findAll(Pageable pageable, SectorFilter filter);
    List<Sector> findAll(SectorFilter filter);
    Optional<Sector> findById(UUID id);
    Sector create(Sector sector);
    Sector update(Sector sector);
    void deleteById(UUID id);

}

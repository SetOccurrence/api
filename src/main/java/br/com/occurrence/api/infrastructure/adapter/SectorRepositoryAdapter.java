package br.com.occurrence.api.infrastructure.adapter;

import br.com.occurrence.api.domain.model.Sector;
import br.com.occurrence.api.domain.repository.SectorRepository;
import br.com.occurrence.api.domain.util.filter.SectorFilter;
import br.com.occurrence.api.infrastructure.adapter.mapper.SectorEntityMapper;
import br.com.occurrence.api.infrastructure.postgres.entity.SectorEntity;
import br.com.occurrence.api.infrastructure.postgres.repository.SectorEntityRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Repository
public class SectorRepositoryAdapter implements SectorRepository {

    private final SectorEntityRepository sectorEntityRepository;
    private final SectorEntityMapper sectorEntityMapper;

    @Override
    public Page<Sector> findAll(Pageable pageable, SectorFilter filter) {
        return sectorEntityRepository.findAll(sectorEntityMapper.map(filter), pageable)
                .map(sectorEntityMapper::toSector);
    }

    @Override
    public List<Sector> findAll(SectorFilter filter) {
        return sectorEntityRepository.findAll(sectorEntityMapper.map(filter)).stream()
                .map(sectorEntityMapper::toSector)
                .toList();
    }

    @Override
    public Optional<Sector> findById(UUID id) {
        return sectorEntityRepository.findById(id)
                .map(sectorEntityMapper::toSector);
    }

    @Override
    public Sector create(Sector sector) {
        SectorEntity entity = sectorEntityMapper.toSectorEntity(sector);
        entity = sectorEntityRepository.save(entity);
        return sectorEntityMapper.toSector(entity);
    }

    @Override
    public Sector update(Sector sector) {
        SectorEntity entity = sectorEntityMapper.toSectorEntity(sector);
        entity = sectorEntityRepository.save(entity);
        return sectorEntityMapper.toSector(entity);
    }

    @Override
    public void deleteById(UUID id) {
        sectorEntityRepository.deleteById(id);
    }

}

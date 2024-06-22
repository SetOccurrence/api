package br.com.occurrence.api.infrastructure.adapter;

import br.com.occurrence.api.domain.model.organization.Sector;
import br.com.occurrence.api.domain.repository.SectorRepository;
import br.com.occurrence.api.domain.util.filter.SectorFilter;
import br.com.occurrence.api.infrastructure.adapter.mapper.SectorEntityMapper;
import br.com.occurrence.api.infrastructure.postgres.entity.SectorEntity;
import br.com.occurrence.api.infrastructure.postgres.repository.SectorEntityRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Component
public class SectorRepositoryAdapter implements SectorRepository {

    private final SectorEntityRepository sectorEntityRepository;

    @Override
    public Page<Sector> findAll(Pageable pageable, SectorFilter filter) {
        return sectorEntityRepository.findAll(SectorEntityMapper.map(filter), pageable)
                .map(SectorEntityMapper::toSector);
    }

    @Override
    public List<Sector> findAll(SectorFilter filter) {
        return sectorEntityRepository.findAll(SectorEntityMapper.map(filter)).stream()
                .map(SectorEntityMapper::toSector)
                .toList();
    }

    @Override
    public Optional<Sector> findById(UUID id) {
        return sectorEntityRepository.findById(id)
                .map(SectorEntityMapper::toSector);
    }

    @Override
    public Sector create(Sector sector) {
        SectorEntity entity = SectorEntityMapper.toSectorEntity(sector);
        entity = sectorEntityRepository.save(entity);
        return SectorEntityMapper.toSector(entity);
    }

    @Override
    public Sector update(Sector sector) {
        SectorEntity entity = SectorEntityMapper.toSectorEntity(sector);
        entity = sectorEntityRepository.save(entity);
        return SectorEntityMapper.toSector(entity);
    }

    @Override
    public void deleteById(UUID id) {
        sectorEntityRepository.deleteById(id);
    }

}

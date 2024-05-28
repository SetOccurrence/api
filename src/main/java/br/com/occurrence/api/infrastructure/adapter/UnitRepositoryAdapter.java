package br.com.occurrence.api.infrastructure.adapter;

import br.com.occurrence.api.domain.model.Unit;
import br.com.occurrence.api.domain.repository.UnitRepository;
import br.com.occurrence.api.domain.util.filter.UnitFilter;
import br.com.occurrence.api.infrastructure.adapter.mapper.UnitEntityMapper;
import br.com.occurrence.api.infrastructure.postgres.entity.UnitEntity;
import br.com.occurrence.api.infrastructure.postgres.repository.UnitEntityRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Repository
public class UnitRepositoryAdapter implements UnitRepository {

    private final UnitEntityRepository unitEntityRepository;
    private final UnitEntityMapper unitEntityMapper;

    @Override
    public Page<Unit> findAll(Pageable pageable, UnitFilter filter) {
        return unitEntityRepository.findAll(unitEntityMapper.map(filter), pageable)
                .map(unitEntityMapper::toUnit);
    }

    @Override
    public List<Unit> findAll(UnitFilter filter) {
        return unitEntityRepository.findAll(unitEntityMapper.map(filter)).stream()
                .map(unitEntityMapper::toUnit)
                .toList();
    }

    @Override
    public Optional<Unit> findById(UUID id) {
        return unitEntityRepository.findById(id)
                .map(unitEntityMapper::toUnit);
    }

    @Override
    public Unit create(Unit unit) {
        UnitEntity entity = unitEntityMapper.toUnitEntity(unit);
        entity = unitEntityRepository.save(entity);
        return unitEntityMapper.toUnit(entity);
    }

    @Override
    public Unit update(Unit unit) {
        UnitEntity entity = unitEntityMapper.toUnitEntity(unit);
        entity = unitEntityRepository.save(entity);
        return unitEntityMapper.toUnit(entity);
    }

    @Override
    public void deleteById(UUID id) {
        unitEntityRepository.deleteById(id);
    }

}

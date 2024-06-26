package br.com.occurrence.api.infrastructure.adapter;

import br.com.occurrence.api.domain.model.organization.Unit;
import br.com.occurrence.api.domain.repository.UnitRepository;
import br.com.occurrence.api.domain.util.filter.UnitFilter;
import br.com.occurrence.api.infrastructure.adapter.mapper.UnitEntityMapper;
import br.com.occurrence.api.infrastructure.postgres.entity.UnitEntity;
import br.com.occurrence.api.infrastructure.postgres.repository.UnitEntityRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Component
public class UnitRepositoryAdapter implements UnitRepository {

    private final UnitEntityRepository unitEntityRepository;

    @Override
    public Page<Unit> findAll(Pageable pageable, UnitFilter filter) {
        return unitEntityRepository.findAll(UnitEntityMapper.map(filter), pageable)
                .map(UnitEntityMapper::toUnit);
    }

    @Override
    public List<Unit> findAll(UnitFilter filter) {
        return unitEntityRepository.findAll(UnitEntityMapper.map(filter)).stream()
                .map(UnitEntityMapper::toUnit)
                .toList();
    }

    @Override
    public Optional<Unit> findById(UUID id) {
        return unitEntityRepository.findById(id)
                .map(UnitEntityMapper::toUnit);
    }

    @Override
    public Unit create(Unit unit) {
        UnitEntity entity = UnitEntityMapper.toUnitEntity(unit);
        entity = unitEntityRepository.save(entity);
        return UnitEntityMapper.toUnit(entity);
    }

    @Override
    public Unit update(Unit unit) {
        UnitEntity entity = UnitEntityMapper.toUnitEntity(unit);
        entity = unitEntityRepository.save(entity);
        return UnitEntityMapper.toUnit(entity);
    }

    @Override
    public void deleteById(UUID id) {
        unitEntityRepository.deleteById(id);
    }

}

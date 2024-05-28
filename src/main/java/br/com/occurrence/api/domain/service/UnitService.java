package br.com.occurrence.api.domain.service;

import br.com.occurrence.api.app.api.dto.UnitFormDto;
import br.com.occurrence.api.domain.mapper.UnitMapper;
import br.com.occurrence.api.domain.model.Unit;
import br.com.occurrence.api.domain.model.User;
import br.com.occurrence.api.domain.repository.UnitRepository;
import br.com.occurrence.api.domain.util.exception.UnitNotFoundException;
import br.com.occurrence.api.domain.util.filter.UnitFilter;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@AllArgsConstructor
@Service
public class UnitService {

    private final UnitRepository unitRepository;
    private final UserService userService;
    private final UnitMapper unitMapper;

    public Page<Unit> findAll(Pageable pageable, UnitFilter filter) {
        return unitRepository.findAll(pageable, filter);
    }

    public Unit findById(UUID id) {
        return unitRepository.findById(id)
                .orElseThrow(() -> new UnitNotFoundException(id));
    }

    public Unit create(UnitFormDto unitFormDTO) {
        User responsible = userService.findById(unitFormDTO.responsibleId());
        Unit unit = unitMapper.toUnit(unitFormDTO, responsible);
        return unitRepository.create(unit);
    }

    public Unit update(UUID id, UnitFormDto unitFormDTO) {
        Unit unit = findById(id);
        User responsible = userService.findById(unitFormDTO.responsibleId());
        unitMapper.updateUnitFromDTO(unit, unitFormDTO, responsible);
        return unitRepository.update(unit);
    }

    public Unit inactivate(UUID id) {
        Unit unit = findById(id);
        unit.setStatus(Unit.Status.INACTIVE);
        return unitRepository.update(unit);
    }

    public Unit logicallyDelete(UUID id) {
        Unit unit = findById(id);
        unit.setStatus(Unit.Status.DELETED);
        return unitRepository.update(unit);
    }

    public void deleteById(UUID id) {
        unitRepository.deleteById(id);
    }

}

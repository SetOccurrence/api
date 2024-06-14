package br.com.occurrence.api.app.api.controller;

import br.com.occurrence.api.app.api.dto.organization.UnitDto;
import br.com.occurrence.api.app.api.dto.organization.UnitFormDto;
import br.com.occurrence.api.domain.mapper.UnitMapper;
import br.com.occurrence.api.domain.model.organization.Unit;
import br.com.occurrence.api.domain.service.UnitService;
import br.com.occurrence.api.domain.util.filter.UnitFilter;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/units")
public class UnitController {

    private final UnitService unitService;

    @GetMapping
    public ResponseEntity<Page<UnitDto>> findAll(@PageableDefault Pageable page,
                                                 @RequestParam(required = false) UnitFilter filter) {
        Page<Unit> units = unitService.findAll(page, filter);
        Page<UnitDto> unitsDto = units.map(UnitMapper::toUnitDTO);
        return ResponseEntity.ok(unitsDto);
    }

    @GetMapping("/list")
    public ResponseEntity<List<UnitDto>> findAll(@RequestParam(required = false) UnitFilter filter) {
        List<Unit> units = unitService.findAll(filter);
        List<UnitDto> unitsDto = units.stream()
                .map(UnitMapper::toUnitDTO)
                .toList();
        return ResponseEntity.ok(unitsDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UnitDto> findById(@PathVariable UUID id) {
        Unit unit = unitService.findById(id);
        UnitDto dto = UnitMapper.toUnitDTO(unit);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<UnitDto> create(@RequestBody @Valid UnitFormDto form) {
        Unit unit = unitService.create(form);
        UnitDto dto = UnitMapper.toUnitDTO(unit);
        return ResponseEntity.created(URI.create("/api/v1/units/" + dto.id())).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UnitDto> update(@PathVariable UUID id, @RequestBody @Valid UnitFormDto form) {
        Unit unit = unitService.update(id, form);
        UnitDto dto = UnitMapper.toUnitDTO(unit);
        return ResponseEntity.ok(dto);
    }

    @PatchMapping("/inactivate/{id}")
    public ResponseEntity<UnitDto> inactivate(@PathVariable UUID id) {
        Unit unit = unitService.inactivate(id);
        UnitDto dto = UnitMapper.toUnitDTO(unit);
        return ResponseEntity.ok(dto);
    }

    @PatchMapping("/delete/{id}")
    public ResponseEntity<UnitDto> logicallyDelete(@PathVariable UUID id) {
        Unit unit = unitService.logicallyDelete(id);
        UnitDto dto = UnitMapper.toUnitDTO(unit);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable UUID id) {
        unitService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}

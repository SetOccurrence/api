package br.com.occurrence.api.app.api.controller;

import br.com.occurrence.api.app.api.dto.organization.SectorDto;
import br.com.occurrence.api.app.api.dto.organization.SectorFormDto;
import br.com.occurrence.api.domain.mapper.SectorMapper;
import br.com.occurrence.api.domain.model.organization.Sector;
import br.com.occurrence.api.domain.service.SectorService;
import br.com.occurrence.api.domain.util.filter.SectorFilter;
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
@RequestMapping("/api/v1/sectors")
public class SectorController {

    private final SectorService sectorService;

    @GetMapping
    public ResponseEntity<Page<SectorDto>> findAll(@PageableDefault Pageable page, SectorFilter filter) {
        Page<Sector> sectors = sectorService.findAll(page, filter);
        Page<SectorDto> sectorsDto = sectors.map(SectorMapper::toSectorDTO);
        return ResponseEntity.ok(sectorsDto);
    }

    @GetMapping("/list")
    public ResponseEntity<List<SectorDto>> findAll(SectorFilter filter) {
        List<Sector> sectors = sectorService.findAll(filter);
        List<SectorDto> sectorsDto = sectors.stream()
                .map(SectorMapper::toSectorDTO)
                .toList();
        return ResponseEntity.ok(sectorsDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SectorDto> findById(@PathVariable UUID id) {
        Sector sector = sectorService.findById(id);
        SectorDto dto = SectorMapper.toSectorDTO(sector);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<SectorDto> create(@RequestBody @Valid SectorFormDto form) {
        Sector sector = sectorService.create(form);
        SectorDto dto = SectorMapper.toSectorDTO(sector);
        return ResponseEntity.created(URI.create("/api/v1/sectors/" + dto.id())).body(dto);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<SectorDto> update(@PathVariable UUID id, @RequestBody SectorFormDto form) {
        Sector sector = sectorService.update(id, form);
        SectorDto dto = SectorMapper.toSectorDTO(sector);
        return ResponseEntity.ok(dto);
    }

    @PatchMapping("/inactivate/{id}")
    public ResponseEntity<SectorDto> inactivate(@PathVariable UUID id) {
        Sector sector = sectorService.inactivate(id);
        SectorDto dto = SectorMapper.toSectorDTO(sector);
        return ResponseEntity.ok(dto);
    }

    @PatchMapping("/delete/{id}")
    public ResponseEntity<SectorDto> logicallyDelete(@PathVariable UUID id) {
        Sector sector = sectorService.logicallyDelete(id);
        SectorDto dto = SectorMapper.toSectorDTO(sector);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable UUID id) {
        sectorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}

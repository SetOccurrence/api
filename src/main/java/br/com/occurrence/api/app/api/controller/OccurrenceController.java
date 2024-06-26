package br.com.occurrence.api.app.api.controller;

import br.com.occurrence.api.app.api.dto.occurrence.OccurrenceDto;
import br.com.occurrence.api.app.api.dto.occurrence.OccurrenceFormDto;
import br.com.occurrence.api.app.api.dto.occurrence.OccurrenceResolveDto;
import br.com.occurrence.api.domain.mapper.OccurrenceMapper;
import br.com.occurrence.api.domain.model.occurrence.Occurrence;
import br.com.occurrence.api.domain.service.OccurrenceService;
import br.com.occurrence.api.domain.util.filter.OccurrenceFilter;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/occurrences")
public class OccurrenceController {

    private final OccurrenceService occurrenceService;
    private final OccurrenceMapper occurrenceMapper;

    @GetMapping
    public ResponseEntity<Page<OccurrenceDto>> findAll(@PageableDefault Pageable page, OccurrenceFilter filter) {
        Page<Occurrence> occurrences = occurrenceService.findAll(page, filter);
        Page<OccurrenceDto> dtos = occurrences.map(occurrenceMapper::toOccurrenceDto);
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/list")
    public ResponseEntity<List<OccurrenceDto>> findAll(OccurrenceFilter filter) {
        List<Occurrence> occurrences = occurrenceService.findAll(filter);
        List<OccurrenceDto> dtos = occurrences.stream()
                .map(occurrenceMapper::toOccurrenceDto)
                .toList();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OccurrenceDto> findById(@PathVariable String id) {
        Occurrence occurrence = occurrenceService.findById(id);
        OccurrenceDto dto = occurrenceMapper.toOccurrenceDto(occurrence);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<OccurrenceDto> create(@RequestBody @Valid OccurrenceFormDto form) {
        Occurrence occurrence = occurrenceService.create(form);
        OccurrenceDto dto = occurrenceMapper.toOccurrenceDto(occurrence);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/{id}")
    public ResponseEntity<OccurrenceDto> resolve(@PathVariable String id, @RequestBody @Valid OccurrenceResolveDto resolveDto) {
        Occurrence occurrence = occurrenceService.resolve(id, resolveDto);
        OccurrenceDto dto = occurrenceMapper.toOccurrenceDto(occurrence);
        return ResponseEntity.ok(dto);
    }

    @PatchMapping("/delete/{id}")
    public ResponseEntity<OccurrenceDto> logicallyDelete(@PathVariable String id) {
        Occurrence occurrence = occurrenceService.logicallyDelete(id);
        OccurrenceDto dto = occurrenceMapper.toOccurrenceDto(occurrence);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        occurrenceService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}

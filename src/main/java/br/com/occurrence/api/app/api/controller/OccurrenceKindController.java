package br.com.occurrence.api.app.api.controller;

import br.com.occurrence.api.app.api.dto.occurrence.OccurrenceKindDto;
import br.com.occurrence.api.app.api.dto.occurrence.OccurrenceKindFormDto;
import br.com.occurrence.api.domain.mapper.OccurrenceKindMapper;
import br.com.occurrence.api.domain.model.occurrence.OccurrenceKind;
import br.com.occurrence.api.domain.service.OccurrenceKindService;
import br.com.occurrence.api.domain.util.filter.OccurrenceKindFilter;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/occurrence-kind")
public class OccurrenceKindController {

    private final OccurrenceKindService occurrenceKindService;
    private final OccurrenceKindMapper occurrenceKindMapper;

    @GetMapping
    public ResponseEntity<Page<OccurrenceKindDto>> findAll(@PageableDefault Pageable page,
                                                           @RequestParam(required = false) OccurrenceKindFilter filter) {
        Page<OccurrenceKind> occurrencesKind = occurrenceKindService.findAll(page, filter);
        //Page<OccurrenceKindDto> dtos = occurrencesKind.map(occurrenceKindMapper::toOccurrenceKindDto);
        //return ResponseEntity.ok(dtos);
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<OccurrenceKindDto> findById(@PathVariable UUID id) {
        OccurrenceKind occurrenceKind = occurrenceKindService.findById(id);
        //OccurrenceKindDto dto = occurrenceKindMapper.toOccurrenceKindDto(occurrenceKind);
        //return ResponseEntity.ok(dto);
        return null;
    }

    @PostMapping
    public ResponseEntity<OccurrenceKindDto> create(@RequestBody @Valid OccurrenceKindFormDto form) {
        OccurrenceKind occurrenceKind = occurrenceKindService.create(form);
        OccurrenceKindDto dto = occurrenceKindMapper.toOccurrenceKindDto(occurrenceKind);
        return ResponseEntity.created(URI.create("/api/v1/occurrence-kind/" + occurrenceKind.getId())).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OccurrenceKindDto> update(@PathVariable UUID id, @RequestBody @Valid OccurrenceKindFormDto form) {
        OccurrenceKind occurrenceKind = occurrenceKindService.update(id, form);
        //OccurrenceKindDto dto = occurrenceKindMapper.toOccurrenceKindDto(occurrenceKind);
        //return ResponseEntity.ok(dto);
        return null;
    }

    @PatchMapping("/delete/{id}")
    public ResponseEntity<OccurrenceKindDto> logicallyDelete(@PathVariable UUID id) {
        OccurrenceKind occurrenceKind = occurrenceKindService.logicallyDelete(id);
        //OccurrenceKindDto dto = occurrenceKindMapper.toOccurrenceKindDto(occurrenceKind);
        //return ResponseEntity.ok(dto);
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable UUID id) {
        occurrenceKindService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}

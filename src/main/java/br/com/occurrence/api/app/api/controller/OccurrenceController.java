package br.com.occurrence.api.app.api.controller;

import br.com.occurrence.api.app.api.dto.occurrence.OccurrenceDto;
import br.com.occurrence.api.app.api.dto.occurrence.OccurrenceFormDto;
import br.com.occurrence.api.domain.mapper.OccurrenceMapper;
import br.com.occurrence.api.domain.model.occurrence.Occurrence;
import br.com.occurrence.api.domain.service.OccurrenceService;
import br.com.occurrence.api.domain.util.filter.OccurrenceFilter;
import jakarta.validation.Valid;
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

    @GetMapping("/pending")
    public ResponseEntity<List<OccurrenceDto>> findAllPendingByLoginUser(OccurrenceFilter filter) {
        return ResponseEntity.ok(null);
    }

    @GetMapping("/open")
    public ResponseEntity<List<OccurrenceDto>> findAllOpenByLoginUser(OccurrenceFilter filter) {
        return ResponseEntity.ok(null);
    }

    @GetMapping
    public ResponseEntity<Page<OccurrenceDto>> findAll(@PageableDefault Pageable page, OccurrenceFilter filter) {
        return ResponseEntity.ok(null);
    }

    @GetMapping("/list")
    public ResponseEntity<List<OccurrenceDto>> findAll(OccurrenceFilter filter) {
        return ResponseEntity.ok(null);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OccurrenceDto> findById(@PathVariable String id) {
        return ResponseEntity.ok(null);
    }

    @PostMapping
    public ResponseEntity<OccurrenceDto> create(@RequestBody @Valid OccurrenceFormDto form) {
        Occurrence occurrence = occurrenceService.create(form);
        return ResponseEntity.ok(null);
    }

    @PostMapping("/{id}")
    public ResponseEntity<OccurrenceDto> resolve(@PathVariable String id) {
        return ResponseEntity.ok(null);
    }

    @PatchMapping("/delete/{id}")
    public ResponseEntity<OccurrenceDto> logicallyDelete(@PathVariable String id) {
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        return ResponseEntity.ok(null);
    }

}

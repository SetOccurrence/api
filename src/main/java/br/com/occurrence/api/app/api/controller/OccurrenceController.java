package br.com.occurrence.api.app.api.controller;

import br.com.occurrence.api.domain.mapper.OccurrenceMapper;
import br.com.occurrence.api.domain.service.OccurrenceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/occurrence")
public class OccurrenceController {

    private final OccurrenceService occurrenceService;
    private final OccurrenceMapper occurrenceMapper;

/*
    findAllPendingByLoginUser() {

    }

    findAllOpenByLoginUser() {

    }

    findAll() {

    }

    new() {

    }

    findById() {

    }

    resolve() {

    }

    @GetMapping
    public ResponseEntity<List<OccurrenceDto>> findAll(@RequestParam(required = false) OccurrenceFilter filter) {
        Page<Occurrence> occurrences = occurrenceService.findAll(page, filter);
        //Page<OccurrenceDto> dtos = occurrences.map(occurrenceMapper::toOccurrenceDto);
        //return ResponseEntity.ok(dtos);
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<OccurrenceDto> findById(@PathVariable UUID id) {
        Occurrence occurrence = occurrenceService.findById(id);
        //OccurrenceDto dto = occurrenceMapper.toOccurrenceDto(occurrence);
        //return ResponseEntity.ok(dto);
        return null;
    }

    @PostMapping
    public ResponseEntity<OccurrenceDto> create(@RequestBody @Valid OccurrenceFormDto form) {
        Occurrence occurrence = occurrenceService.create(form);
        //OccurrenceDto dto = occurrenceMapper.toOccurrenceDto(occurrence);
        //return ResponseEntity.created(URI.create("/api/v1/occurrence/" + occurrence.getId())).body(dto);
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<OccurrenceDto> update(@PathVariable UUID id, @RequestBody @Valid OccurrenceFormDto form) {
        Occurrence occurrence = occurrenceService.update(id, form);
        //OccurrenceDto dto = occurrenceMapper.toOccurrenceDto(occurrence);
        //return ResponseEntity.ok(dto);
        return null;
    }

    @PatchMapping("/delete/{id}")
    public ResponseEntity<OccurrenceDto> logicallyDelete(@PathVariable UUID id) {
        Occurrence occurrence = occurrenceService.logicallyDelete(id);
        //OccurrenceDto dto = occurrenceMapper.toOccurrenceDto(occurrence);
        //return ResponseEntity.ok(dto);
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable UUID id) {
        occurrenceService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
*/
}

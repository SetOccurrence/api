package br.com.occurrence.api.app.api.controller;

import br.com.occurrence.api.app.api.dto.organization.DepartmentDto;
import br.com.occurrence.api.app.api.dto.organization.DepartmentFormDto;
import br.com.occurrence.api.app.api.dto.organization.UnitDto;
import br.com.occurrence.api.domain.mapper.DepartmentMapper;
import br.com.occurrence.api.domain.mapper.UnitMapper;
import br.com.occurrence.api.domain.model.organization.Department;
import br.com.occurrence.api.domain.model.organization.Unit;
import br.com.occurrence.api.domain.service.DepartmentService;
import br.com.occurrence.api.domain.util.filter.DepartmentFilter;
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
@RequestMapping("/api/v1/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    @GetMapping
    public ResponseEntity<Page<DepartmentDto>> findAll(@PageableDefault Pageable page,
                                                       @RequestParam(required = false) DepartmentFilter filter) {
        Page<Department> departments = departmentService.findAll(page, filter);
        Page<DepartmentDto> departmentsDto = departments.map(DepartmentMapper::toDepartmentDTO);
        return ResponseEntity.ok(departmentsDto);
    }

    @GetMapping("/list")
    public ResponseEntity<List<DepartmentDto>> findAll(@RequestParam(required = false) DepartmentFilter filter) {
        List<Department> departments = departmentService.findAll(filter);
        List<DepartmentDto> departmentsDto = departments.stream()
                .map(DepartmentMapper::toDepartmentDTO)
                .toList();
        return ResponseEntity.ok(departmentsDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDto> findById(@PathVariable UUID id) {
        Department department = departmentService.findById(id);
        DepartmentDto dto = DepartmentMapper.toDepartmentDTO(department);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<DepartmentDto> create(@RequestBody @Valid DepartmentFormDto form) {
        Department department = departmentService.create(form);
        DepartmentDto dto = DepartmentMapper.toDepartmentDTO(department);
        return ResponseEntity.created(URI.create("/api/v1/departments/" + dto.id())).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartmentDto> update(@PathVariable UUID id, @RequestBody @Valid DepartmentFormDto form) {
        Department department = departmentService.update(id, form);
        DepartmentDto dto = DepartmentMapper.toDepartmentDTO(department);
        return ResponseEntity.ok(dto);
    }

    @PatchMapping("/inactivate/{id}")
    public ResponseEntity<DepartmentDto> inactivate(@PathVariable UUID id) {
        Department department = departmentService.inactivate(id);
        DepartmentDto dto = DepartmentMapper.toDepartmentDTO(department);
        return ResponseEntity.ok(dto);
    }

    @PatchMapping("/delete/{id}")
    public ResponseEntity<DepartmentDto> logicallyDelete(@PathVariable UUID id) {
        Department department = departmentService.logicallyDelete(id);
        DepartmentDto dto = DepartmentMapper
                .toDepartmentDTO(department);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable UUID id) {
        departmentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}

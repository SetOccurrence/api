package br.com.occurrence.api.app.api.controller;

import br.com.occurrence.api.app.api.dto.organization.TeamDto;
import br.com.occurrence.api.app.api.dto.organization.TeamFormDto;
import br.com.occurrence.api.domain.mapper.TeamMapper;
import br.com.occurrence.api.domain.model.organization.Team;
import br.com.occurrence.api.domain.service.TeamService;
import br.com.occurrence.api.domain.util.filter.TeamFilter;
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
@RequestMapping("/api/v1/teams")
public class TeamController {

    private final TeamService teamService;

    @GetMapping
    public ResponseEntity<Page<TeamDto>> findAll(@PageableDefault Pageable page, TeamFilter filter) {
        Page<Team> teams = teamService.findAll(page, filter);
        Page<TeamDto> teamsDto = teams.map(TeamMapper::toTeamDTO);
        return ResponseEntity.ok(teamsDto);
    }

    @GetMapping("/list")
    public ResponseEntity<List<TeamDto>> findAll(TeamFilter filter) {
        List<Team> teams = teamService.findAll(filter);
        List<TeamDto> teamsDto = teams.stream()
                .map(TeamMapper::toTeamDTO)
                .toList();
        return ResponseEntity.ok(teamsDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeamDto> findById(@PathVariable UUID id) {
        Team team = teamService.findById(id);
        TeamDto dto = TeamMapper.toTeamDTO(team);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<TeamDto> create(@RequestBody @Valid TeamFormDto form) {
        Team team = teamService.create(form);
        TeamDto dto = TeamMapper.toTeamDTO(team);
        return ResponseEntity.created(URI.create("/api/v1/teams/" + dto.id())).body(dto);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TeamDto> update(@PathVariable UUID id, @RequestBody TeamFormDto form) {
        Team team = teamService.update(id, form);
        TeamDto dto = TeamMapper.toTeamDTO(team);
        return ResponseEntity.ok(dto);
    }

    @PatchMapping("/inactivate/{id}")
    public ResponseEntity<TeamDto> inactivate(@PathVariable UUID id) {
        Team team = teamService.inactivate(id);
        TeamDto dto = TeamMapper.toTeamDTO(team);
        return ResponseEntity.ok(dto);
    }

    @PatchMapping("/delete/{id}")
    public ResponseEntity<TeamDto> logicallyDelete(@PathVariable UUID id) {
        Team team = teamService.logicallyDelete(id);
        TeamDto dto = TeamMapper.toTeamDTO(team);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable UUID id) {
        teamService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}

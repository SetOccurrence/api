package br.com.occurrence.api.domain.service;

import br.com.occurrence.api.app.api.dto.organization.TeamFormDto;
import br.com.occurrence.api.domain.mapper.TeamMapper;
import br.com.occurrence.api.domain.model.organization.Sector;
import br.com.occurrence.api.domain.model.organization.Team;
import br.com.occurrence.api.domain.model.organization.User;
import br.com.occurrence.api.domain.repository.TeamRepository;
import br.com.occurrence.api.domain.util.exception.TeamNotFoundException;
import br.com.occurrence.api.domain.util.filter.TeamFilter;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@AllArgsConstructor
@Service
public class TeamService {

    private final TeamRepository teamRepository;
    private final UserReadService userReadService;
    private final SectorService sectorService;

    public Page<Team> findAll(Pageable pageable, TeamFilter filter) {
        return teamRepository.findAll(pageable, filter);
    }

    public List<Team> findAll(TeamFilter filter) {
        return teamRepository.findAll(filter);
    }

    public Team findById(UUID id) {
        return teamRepository.findById(id)
                .orElseThrow(() -> new TeamNotFoundException(id));
    }

    public Team create(TeamFormDto teamFormDTO) {
        User responsible = userReadService.findById(teamFormDTO.responsibleId());
        Sector sector = sectorService.findById(teamFormDTO.sectorId());
        Team team = TeamMapper.toTeam(teamFormDTO, responsible, sector);
        return teamRepository.create(team);
    }

    public Team update(UUID id, TeamFormDto teamFormDTO) {
        Team team = findById(id);
        User responsible = userReadService.findById(teamFormDTO.responsibleId());
        Sector sector = sectorService.findById(teamFormDTO.sectorId());
        TeamMapper.updateTeamFromDTO(team, teamFormDTO, responsible, sector);
        return teamRepository.update(team);
    }

    public Team inactivate(UUID id) {
        Team team = findById(id);
        team.setStatus(Team.Status.INACTIVE);
        return teamRepository.update(team);
    }

    public Team logicallyDelete(UUID id) {
        Team team = findById(id);
        team.setStatus(Team.Status.DELETED);
        return teamRepository.update(team);
    }

    public void deleteById(UUID id) {
        teamRepository.deleteById(id);
    }

}

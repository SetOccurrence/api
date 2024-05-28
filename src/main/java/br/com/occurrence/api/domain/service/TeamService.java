package br.com.occurrence.api.domain.service;

import br.com.occurrence.api.app.api.dto.TeamFormDto;
import br.com.occurrence.api.domain.mapper.TeamMapper;
import br.com.occurrence.api.domain.model.Team;
import br.com.occurrence.api.domain.model.User;
import br.com.occurrence.api.domain.repository.TeamRepository;
import br.com.occurrence.api.domain.util.exception.TeamNotFoundException;
import br.com.occurrence.api.domain.util.filter.TeamFilter;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@AllArgsConstructor
@Service
public class TeamService {

    private final TeamRepository teamRepository;
    private final UserService userService;
    private final TeamMapper teamMapper;

    public Page<Team> findAll(Pageable pageable, TeamFilter filter) {
        return teamRepository.findAll(pageable, filter);
    }

    public Team findById(UUID id) {
        return teamRepository.findById(id)
                .orElseThrow(() -> new TeamNotFoundException(id));
    }

    public Team create(TeamFormDto teamFormDTO) {
        User responsible = userService.findById(teamFormDTO.responsibleId());
        Team team = teamMapper.toTeam(teamFormDTO, responsible);
        return teamRepository.create(team);
    }

    public Team update(UUID id, TeamFormDto teamFormDTO) {
        Team team = findById(id);
        User responsible = userService.findById(teamFormDTO.responsibleId());
        teamMapper.updateTeamFromDTO(team, teamFormDTO, responsible);
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

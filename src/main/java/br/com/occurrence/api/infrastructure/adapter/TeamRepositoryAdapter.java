package br.com.occurrence.api.infrastructure.adapter;

import br.com.occurrence.api.domain.model.organization.Team;
import br.com.occurrence.api.domain.repository.TeamRepository;
import br.com.occurrence.api.domain.util.filter.TeamFilter;
import br.com.occurrence.api.infrastructure.adapter.mapper.TeamEntityMapper;
import br.com.occurrence.api.infrastructure.postgres.entity.TeamEntity;
import br.com.occurrence.api.infrastructure.postgres.repository.TeamEntityRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Repository
public class TeamRepositoryAdapter implements TeamRepository {

    private final TeamEntityRepository teamEntityRepository;

    @Override
    public Page<Team> findAll(Pageable pageable, TeamFilter filter) {
        return teamEntityRepository.findAll(TeamEntityMapper.map(filter), pageable)
                .map(TeamEntityMapper::toTeam);
    }

    @Override
    public List<Team> findAll(TeamFilter filter) {
        return teamEntityRepository.findAll(TeamEntityMapper.map(filter)).stream()
                .map(TeamEntityMapper::toTeam)
                .toList();
    }

    @Override
    public Optional<Team> findById(UUID id) {
        return teamEntityRepository.findById(id)
                .map(TeamEntityMapper::toTeam);
    }

    @Override
    public Team create(Team team) {
        TeamEntity entity = TeamEntityMapper.toTeamEntity(team);
        entity = teamEntityRepository.save(entity);
        return TeamEntityMapper.toTeam(entity);
    }

    @Override
    public Team update(Team team) {
        TeamEntity entity = TeamEntityMapper.toTeamEntity(team);
        entity = teamEntityRepository.save(entity);
        return TeamEntityMapper.toTeam(entity);
    }

    @Override
    public void deleteById(UUID id) {
        teamEntityRepository.deleteById(id);
    }

}

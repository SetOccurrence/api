package br.com.occurrence.api.domain.repository;

import br.com.occurrence.api.domain.model.organization.Team;
import br.com.occurrence.api.domain.util.filter.TeamFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TeamRepository {

    Page<Team> findAll(Pageable pageable, TeamFilter filter);
    List<Team> findAll(TeamFilter filter);
    Optional<Team> findById(UUID id);
    Team create(Team team);
    Team update(Team team);
    void deleteById(UUID id);

}

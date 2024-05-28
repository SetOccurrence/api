package br.com.occurrence.api.infrastructure.adapter.mapper;

import br.com.occurrence.api.domain.model.Team;
import br.com.occurrence.api.domain.util.filter.TeamFilter;
import br.com.occurrence.api.infrastructure.postgres.entity.TeamEntity;
import br.com.occurrence.api.infrastructure.postgres.specification.TeamSpecification;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TeamEntityMapper {

    TeamEntity toTeamEntity(Team team);
    Team toTeam(TeamEntity entity);

    TeamSpecification map(TeamFilter teamFilter);

    Team.Status map(TeamEntity.Status status);
    TeamEntity.Status map(Team.Status status);

}

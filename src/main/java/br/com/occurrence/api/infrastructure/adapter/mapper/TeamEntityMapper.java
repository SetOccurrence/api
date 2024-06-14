package br.com.occurrence.api.infrastructure.adapter.mapper;

import br.com.occurrence.api.domain.model.organization.Team;
import br.com.occurrence.api.domain.util.filter.TeamFilter;
import br.com.occurrence.api.infrastructure.postgres.entity.TeamEntity;
import br.com.occurrence.api.infrastructure.postgres.specification.TeamSpecification;
import lombok.experimental.UtilityClass;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

@UtilityClass
public class TeamEntityMapper {

    public static TeamEntity toTeamEntity(Team team) {
        if (team == null) {
            return null;
        }
        TeamEntity entity = new TeamEntity();
        entity.setId(team.getId());
        entity.setName(team.getName());
        entity.setDescription(team.getDescription());
        entity.setResponsible(UserEntityMapper.toUserEntity(team.getResponsible()));
        entity.setSector(SectorEntityMapper.toSectorEntityWithoutRelations(team.getSector()));
        entity.setContact(ContactEntityMapper.toContactEntity(team.getContact()));
        entity.setUsers(UserEntityMapper.toUserEntity(team.getUsers()));
        entity.setStatus(TeamEntity.Status.valueOf(team.getStatus().name()));
        entity.setCreatedBy(team.getCreatedBy());
        entity.setCreatedAt(team.getCreatedAt());
        entity.setUpdatedBy(team.getUpdatedBy());
        entity.setUpdatedAt(team.getUpdatedAt());
        return entity;
    }

    public static TeamEntity toTeamEntityWithoutRelations(Team team) {
        if (team == null) {
            return null;
        }
        TeamEntity entity = new TeamEntity();
        entity.setId(team.getId());
        entity.setName(team.getName());
        entity.setDescription(team.getDescription());
        entity.setContact(ContactEntityMapper.toContactEntity(team.getContact()));
        entity.setStatus(TeamEntity.Status.valueOf(team.getStatus().name()));
        entity.setCreatedBy(team.getCreatedBy());
        entity.setCreatedAt(team.getCreatedAt());
        entity.setUpdatedBy(team.getUpdatedBy());
        entity.setUpdatedAt(team.getUpdatedAt());
        return entity;
    }

    public static List<TeamEntity> toTeamEntity(List<Team> teams) {
        if (CollectionUtils.isEmpty(teams)) {
            return Collections.emptyList();
        }
        return teams.stream()
                .map(TeamEntityMapper::toTeamEntity)
                .toList();
    }

    public static List<TeamEntity> toTeamEntityWithoutRelations(List<Team> teams) {
        if (CollectionUtils.isEmpty(teams)) {
            return Collections.emptyList();
        }
        return teams.stream()
                .map(TeamEntityMapper::toTeamEntityWithoutRelations)
                .toList();
    }

    public static Team toTeam(TeamEntity entity) {
        if (entity == null) {
            return null;
        }
        Team team = new Team();
        team.setId(entity.getId());
        team.setName(entity.getName());
        team.setDescription(entity.getDescription());
        team.setSector(SectorEntityMapper.toSectorWithoutRelations(entity.getSector()));
        team.setResponsible(UserEntityMapper.toUser(entity.getResponsible()));
        team.setContact(ContactEntityMapper.toContact(entity.getContact()));
        team.setUsers(UserEntityMapper.toUser(entity.getUsers()));
        team.setStatus(Team.Status.valueOf(entity.getStatus().name()));
        team.setCreatedBy(entity.getCreatedBy());
        team.setCreatedAt(entity.getCreatedAt());
        team.setUpdatedBy(entity.getUpdatedBy());
        team.setUpdatedAt(entity.getUpdatedAt());
        return team;
    }

    public static Team toTeamWithoutRelations(TeamEntity entity) {
        if (entity == null) {
            return null;
        }
        Team team = new Team();
        team.setId(entity.getId());
        team.setName(entity.getName());
        team.setDescription(entity.getDescription());
        team.setContact(ContactEntityMapper.toContact(entity.getContact()));
        team.setStatus(Team.Status.valueOf(entity.getStatus().name()));
        team.setCreatedBy(entity.getCreatedBy());
        team.setCreatedAt(entity.getCreatedAt());
        team.setUpdatedBy(entity.getUpdatedBy());
        team.setUpdatedAt(entity.getUpdatedAt());
        return team;
    }

    public static List<Team> toTeam(List<TeamEntity> entities) {
        if (CollectionUtils.isEmpty(entities)) {
            return Collections.emptyList();
        }
        return entities.stream()
                .map(TeamEntityMapper::toTeam)
                .toList();
    }

    public static List<Team> toTeamWithoutRelations(List<TeamEntity> entities) {
        if (CollectionUtils.isEmpty(entities)) {
            return Collections.emptyList();
        }
        return entities.stream()
                .map(TeamEntityMapper::toTeamWithoutRelations)
                .toList();
    }

    public static TeamSpecification map(TeamFilter filter) {
        if (filter == null) {
            return null;
        }
        TeamSpecification specification = new TeamSpecification();
        specification.setName(filter.name());
        specification.setResponsibleId(filter.responsible() != null ? filter.responsible().id() : null);
        specification.setResponsibleName(filter.responsible() != null ? filter.responsible().name() : null);
        specification.setStatus(filter.status() != null ? TeamEntity.Status.valueOf(filter.status().name()) : null);
        return specification;
    }

}

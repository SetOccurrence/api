package br.com.occurrence.api.domain.mapper;

import br.com.occurrence.api.app.api.dto.TeamDto;
import br.com.occurrence.api.app.api.dto.TeamFormDto;
import br.com.occurrence.api.domain.model.Team;
import br.com.occurrence.api.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TeamMapper {

    Team toTeam(TeamFormDto teamFormDTO);

    default Team toTeam(TeamFormDto teamFormDTO, User responsible) {
        if (teamFormDTO == null) {
            return null;
        }
        Team team = toTeam(teamFormDTO);
        team.setResponsible(responsible);
        return team;
    }

    void updateTeamFromDTO(@MappingTarget Team team, TeamFormDto teamFormDTO);

    default void updateTeamFromDTO(@MappingTarget Team team, TeamFormDto teamFormDTO, User responsible) {
        if (team == null) {
            return;
        }
        updateTeamFromDTO(team, teamFormDTO);
        team.setResponsible(responsible);
    }

    TeamDto toTeamDTO(Team team);

}

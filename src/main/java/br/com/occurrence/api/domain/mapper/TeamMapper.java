package br.com.occurrence.api.domain.mapper;

import br.com.occurrence.api.app.api.dto.organization.TeamDto;
import br.com.occurrence.api.app.api.dto.organization.TeamFormDto;
import br.com.occurrence.api.app.api.dto.organization.UserDto;
import br.com.occurrence.api.domain.model.organization.Sector;
import br.com.occurrence.api.domain.model.organization.Team;
import br.com.occurrence.api.domain.model.organization.User;
import br.com.occurrence.api.domain.util.PropertiesHelper;
import lombok.experimental.UtilityClass;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

@UtilityClass
public class TeamMapper {

    public static Team toTeam(TeamFormDto teamFormDTO, User responsible, Sector sector) {
        if (teamFormDTO == null) {
            return null;
        }
        Team team = new Team();
        team.setName(teamFormDTO.name());
        team.setDescription(teamFormDTO.description());
        team.setContact(ContactMapper.toContact(teamFormDTO.contact()));
        team.setResponsible(responsible);
        team.setSector(sector);
        return team;
    }

    public static TeamDto toTeamDTO(Team team) {
        if (team == null) {
            return null;
        }
        return new TeamDto(
            team.getId(),
            team.getName(),
            team.getDescription(),
            UserMapper.toUserDTO(team.getResponsible()),
            ContactMapper.toContactDto(team.getContact()),
            SectorMapper.toSectorDTO(team.getSector()),
            UserMapper.toUserDTO(team.getUsers()),
            TeamDto.Status.valueOf(team.getStatus().name())
        );
    }

    public static List<TeamDto> toTeamDTO(List<Team> teams) {
        if (CollectionUtils.isEmpty(teams)) {
            return Collections.emptyList();
        }
        return teams.stream()
                .map(TeamMapper::toTeamDTO)
                .toList();
    }

    public static void updateTeamFromDTO(Team team, TeamFormDto teamFormDTO, User responsible, Sector sector) {
        if (team == null) {
            return;
        }
        PropertiesHelper.copyNonNullProperties(teamFormDTO, team);
        if (responsible != null) {
            team.setResponsible(responsible);
        }
        if (sector != null) {
            team.setSector(sector);
        }
    }

}

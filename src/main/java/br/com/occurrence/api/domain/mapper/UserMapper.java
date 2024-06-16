package br.com.occurrence.api.domain.mapper;

import br.com.occurrence.api.app.api.dto.organization.UserDto;
import br.com.occurrence.api.app.api.dto.organization.UserFormDto;
import br.com.occurrence.api.domain.model.organization.Team;
import br.com.occurrence.api.domain.model.organization.User;
import br.com.occurrence.api.domain.util.PropertiesHelper;
import lombok.experimental.UtilityClass;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

@UtilityClass
public class UserMapper {

    public static User toUser(UserFormDto userFormDto, Team team, String encodedPassword) {
        if (userFormDto == null) {
            return null;
        }
        User user = new User();
        user.setName(userFormDto.name());
        user.setEmail(userFormDto.email());
        user.setLogin(userFormDto.login());
        user.setPassword(encodedPassword);
        user.setContact(ContactMapper.toContact(userFormDto.contact()));
        user.setTeam(team);
        return user;
    }

    public static UserDto toUserDTO(User user) {
        if (user == null) {
            return null;
        }
        return new UserDto(
            user.getId(),
            user.getName(),
            user.getEmail(),
            user.getLogin(),
            UserDto.Status.valueOf(user.getStatus().name()),
            TeamMapper.toTeamDTO(user.getTeam()),
            ContactMapper.toContactDto(user.getContact())
        );
    }

    public static List<UserDto> toUserDTO(List<User> users) {
        if (CollectionUtils.isEmpty(users)) {
            return Collections.emptyList();
        }
        return users.stream()
                .map(UserMapper::toUserDTO)
                .toList();
    }

    public static void updateUserFromDTO(User user, UserFormDto userFormDTO, Team team) {
        PropertiesHelper.copyNonNullProperties(userFormDTO, user);
        if (team != null) {
            user.setTeam(team);
        }
    }

}

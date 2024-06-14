package br.com.occurrence.api.domain.service;

import br.com.occurrence.api.app.api.dto.organization.UserFormDto;
import br.com.occurrence.api.domain.mapper.UserMapper;
import br.com.occurrence.api.domain.model.organization.Team;
import br.com.occurrence.api.domain.model.organization.User;
import br.com.occurrence.api.domain.repository.UserRepository;
import br.com.occurrence.api.domain.util.exception.UserAlreadyExistsException;
import br.com.occurrence.api.domain.util.exception.UserNotFoundException;
import br.com.occurrence.api.domain.util.filter.UserFilter;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@AllArgsConstructor
@Service
public class UserCommandService {

    private final UserRepository userRepository;
    private final UserReadService userReadService;
    private final TeamService teamService;

    public User create(UserFormDto userFormDTO) {
        boolean exists = userRepository.existsByLogin(userFormDTO.login());
        if (exists) {
            throw new UserAlreadyExistsException();
        }
        Team team = teamService.findById(userFormDTO.teamId());
        User user = UserMapper.toUser(userFormDTO, team);
        return userRepository.create(user);
    }

    public User update(UUID id, UserFormDto userFormDTO) {
        User user = userReadService.findById(id);
        Team team = teamService.findById(userFormDTO.teamId());
        UserMapper.updateUserFromDTO(user, userFormDTO, team);
        return userRepository.update(user);
    }

    public User activate(UUID id) {
        User user = userReadService.findById(id);
        user.setStatus(User.Status.ACTIVE);
        return userRepository.update(user);
    }

    public User inactivate(UUID id) {
        User user = userReadService.findById(id);
        user.setStatus(User.Status.INACTIVE);
        return userRepository.update(user);
    }

    public User block(UUID id) {
        User user = userReadService.findById(id);
        user.setStatus(User.Status.BLOCKED);
        return userRepository.update(user);
    }

    public User logicallyDelete(UUID id) {
        User user = userReadService.findById(id);
        user.setStatus(User.Status.DELETED);
        return userRepository.update(user);
    }

    public void deleteById(UUID id) {
        userRepository.deleteById(id);
    }

}

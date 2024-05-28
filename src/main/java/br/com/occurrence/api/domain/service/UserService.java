package br.com.occurrence.api.domain.service;

import br.com.occurrence.api.app.api.dto.UserFormDto;
import br.com.occurrence.api.domain.mapper.UserMapper;
import br.com.occurrence.api.domain.model.User;
import br.com.occurrence.api.domain.repository.UserRepository;
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
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public Page<User> findAll(Pageable pageable, UserFilter filter) {
        return userRepository.findAll(pageable, filter);
    }

    public User findById(UUID id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    public User create(UserFormDto userFormDTO) {
        User user = userMapper.toUser(userFormDTO);
        return userRepository.create(user);
    }

    public User update(UUID id, UserFormDto userFormDTO) {
        User user = findById(id);
        userMapper.updateUserFromDTO(user, userFormDTO);
        return userRepository.update(user);
    }

    public User activate(UUID id) {
        User user = findById(id);
        user.setStatus(User.Status.ACTIVE);
        return userRepository.update(user);
    }

    public User inactivate(UUID id) {
        User user = findById(id);
        user.setStatus(User.Status.INACTIVE);
        return userRepository.update(user);
    }

    public User block(UUID id) {
        User user = findById(id);
        user.setStatus(User.Status.BLOCKED);
        return userRepository.update(user);
    }

    public User logicallyDelete(UUID id) {
        User user = findById(id);
        user.setStatus(User.Status.DELETED);
        return userRepository.update(user);
    }

    public void deleteById(UUID id) {
        userRepository.deleteById(id);
    }

}

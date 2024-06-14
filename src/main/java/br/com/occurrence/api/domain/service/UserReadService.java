package br.com.occurrence.api.domain.service;

import br.com.occurrence.api.domain.model.organization.User;
import br.com.occurrence.api.domain.repository.UserRepository;
import br.com.occurrence.api.domain.util.exception.UserNotFoundException;
import br.com.occurrence.api.domain.util.filter.UserFilter;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@AllArgsConstructor
@Service
public class UserReadService {

    private final UserRepository userRepository;

    public Page<User> findAll(Pageable pageable, UserFilter filter) {
        return userRepository.findAll(pageable, filter);
    }

    public List<User> findAll(UserFilter filter) {
        return userRepository.findAll(filter);
    }

    public User findById(UUID id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    public User findByLogin(String login) {
        return userRepository.findByLogin(login)
                .orElseThrow(UserNotFoundException::new);
    }

    public boolean exitsByLogin(String login) {
        return userRepository.existsByLogin(login);
    }

}

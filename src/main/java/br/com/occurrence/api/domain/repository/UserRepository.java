package br.com.occurrence.api.domain.repository;

import br.com.occurrence.api.domain.model.organization.User;
import br.com.occurrence.api.domain.util.filter.UserFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository {

    Page<User> findAll(Pageable pageable, UserFilter filter);
    List<User> findAll(UserFilter filter);
    Optional<User> findById(UUID id);
    Optional<User> findByLogin(String login);
    boolean existsByLogin(String login);
    User create(User user);
    User update(User user);
    void deleteById(UUID id);

}

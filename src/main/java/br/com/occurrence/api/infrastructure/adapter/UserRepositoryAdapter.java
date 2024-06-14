package br.com.occurrence.api.infrastructure.adapter;

import br.com.occurrence.api.domain.model.organization.User;
import br.com.occurrence.api.domain.repository.UserRepository;
import br.com.occurrence.api.domain.util.filter.UserFilter;
import br.com.occurrence.api.infrastructure.adapter.mapper.UserEntityMapper;
import br.com.occurrence.api.infrastructure.postgres.entity.UserEntity;
import br.com.occurrence.api.infrastructure.postgres.repository.UserEntityRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Repository
public class UserRepositoryAdapter implements UserRepository {

    private final UserEntityRepository userEntityRepository;

    @Override
    public Page<User> findAll(Pageable pageable, UserFilter filter) {
        return userEntityRepository.findAll(UserEntityMapper.map(filter), pageable)
                .map(UserEntityMapper::toUser);
    }

    @Override
    public List<User> findAll(UserFilter filter) {
        return userEntityRepository.findAll(UserEntityMapper.map(filter)).stream()
                .map(UserEntityMapper::toUser)
                .toList();
    }

    @Override
    public Optional<User> findById(UUID id) {
        return userEntityRepository.findById(id)
                .map(UserEntityMapper::toUser);
    }

    @Override
    public Optional<User> findByLogin(String login) {
        return userEntityRepository.findByLogin(login)
                .map(UserEntityMapper::toUser);
    }

    @Override
    public boolean existsByLogin(String login) {
        return userEntityRepository.existsByLogin(login);
    }

    @Override
    public User create(User user) {
        UserEntity entity = UserEntityMapper.toUserEntity(user);
        entity = userEntityRepository.save(entity);
        return UserEntityMapper.toUser(entity);
    }

    @Override
    public User update(User user) {
        UserEntity entity = UserEntityMapper.toUserEntity(user);
        entity = userEntityRepository.save(entity);
        return UserEntityMapper.toUser(entity);
    }

    @Override
    public void deleteById(UUID id) {
        userEntityRepository.deleteById(id);
    }

}

package br.com.occurrence.api.infrastructure.adapter.mapper;

import br.com.occurrence.api.domain.model.organization.User;
import br.com.occurrence.api.domain.util.filter.UserFilter;
import br.com.occurrence.api.infrastructure.postgres.entity.UserEntity;
import br.com.occurrence.api.infrastructure.postgres.specification.UserSpecification;
import lombok.experimental.UtilityClass;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

@UtilityClass
public class UserEntityMapper {

    public static User toUser(UserEntity entity) {
        if (entity == null) {
            return null;
        }
        User user = new User();
        user.setId(entity.getId());
        user.setName(entity.getName());
        user.setEmail(entity.getEmail());
        user.setLogin(entity.getLogin());
        user.setPassword(entity.getPassword());
        user.setTeam(TeamEntityMapper.toTeamWithoutRelations(entity.getTeam()));
        user.setContact(ContactEntityMapper.toContact(entity.getContact()));
        user.setStatus(User.Status.valueOf(entity.getStatus().name()));
        user.setCreatedBy(entity.getCreatedBy());
        user.setCreatedAt(entity.getCreatedAt());
        user.setUpdatedBy(entity.getUpdatedBy());
        user.setUpdatedAt(entity.getUpdatedAt());
        return user;
    }

    public static List<User> toUser(List<UserEntity> entities) {
        if (CollectionUtils.isEmpty(entities)) {
            return Collections.emptyList();
        }
        return entities.stream()
                .map(UserEntityMapper::toUser)
                .toList();
    }

    public static UserEntity toUserEntity(User user) {
        if (user == null) {
            return null;
        }
        UserEntity entity = new UserEntity();
        entity.setId(user.getId());
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setLogin(user.getLogin());
        entity.setPassword(user.getPassword());
        entity.setTeam(TeamEntityMapper.toTeamEntityWithoutRelations(user.getTeam()));
        entity.setContact(ContactEntityMapper.toContactEntity(user.getContact()));
        entity.setStatus(UserEntity.Status.valueOf(user.getStatus().name()));
        entity.setCreatedBy(user.getCreatedBy());
        entity.setCreatedAt(user.getCreatedAt());
        entity.setUpdatedBy(user.getUpdatedBy());
        entity.setUpdatedAt(user.getUpdatedAt());
        return entity;
    }

    public static List<UserEntity> toUserEntity(List<User> users) {
        if (CollectionUtils.isEmpty(users)) {
            return Collections.emptyList();
        }
        return users.stream()
                .map(UserEntityMapper::toUserEntity)
                .toList();
    }

    public static UserSpecification map(UserFilter filter) {
        if (filter == null) {
            return null;
        }
        UserSpecification specification = new UserSpecification();
        specification.setSearch(filter.getSearch());
        specification.setStatus(filter.getStatus() != null ? UserEntity.Status.valueOf(filter.getStatus().name()) : null);
        return specification;
    }

}

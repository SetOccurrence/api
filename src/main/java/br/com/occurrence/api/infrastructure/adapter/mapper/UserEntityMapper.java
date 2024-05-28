package br.com.occurrence.api.infrastructure.adapter.mapper;

import br.com.occurrence.api.domain.model.User;
import br.com.occurrence.api.domain.util.filter.UserFilter;
import br.com.occurrence.api.infrastructure.postgres.entity.UserEntity;
import br.com.occurrence.api.infrastructure.postgres.specification.UserSpecification;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserEntityMapper {

    UserEntity toUserEntity(User user);
    User toUser(UserEntity entity);

    UserSpecification map(UserFilter userFilter);

    User.Status map(UserEntity.Status status);
    UserEntity.Status map(User.Status status);

}

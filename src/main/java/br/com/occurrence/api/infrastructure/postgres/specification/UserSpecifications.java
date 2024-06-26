package br.com.occurrence.api.infrastructure.postgres.specification;

import br.com.occurrence.api.infrastructure.postgres.entity.TeamEntity;
import br.com.occurrence.api.infrastructure.postgres.entity.UserEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;
import lombok.experimental.UtilityClass;
import org.springframework.data.jpa.domain.Specification;

import java.util.UUID;

@UtilityClass
public class UserSpecifications {

    public static Specification<UserEntity> nameLike(String name) {
        return (Root<UserEntity> root, CriteriaQuery<?> query, CriteriaBuilder builder) ->
                builder.like(root.get("name"), "%" + name + "%");
    }

    public static Specification<UserEntity> emailLike(String email) {
        return (Root<UserEntity> root, CriteriaQuery<?> query, CriteriaBuilder builder) ->
                builder.like(root.get("email"), email);
    }

    public static Specification<UserEntity> loginLike(String login) {
        return (Root<UserEntity> root, CriteriaQuery<?> query, CriteriaBuilder builder) ->
                builder.like(root.get("login"), login);
    }

    public static Specification<UserEntity> teamIdEqual(String teamId) {
        return (Root<UserEntity> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> {
            Join<UserEntity, TeamEntity> teamJoin = root.join("team");
            return builder.equal(teamJoin.get("id"), UUID.fromString(teamId));
        };
    }

    public static Specification<UserEntity> statusEqual(UserEntity.Status status) {
        return (Root<UserEntity> root, CriteriaQuery<?> query, CriteriaBuilder builder) ->
                builder.equal(root.get("status"), status.name());
    }

    public static Specification<UserEntity> statusNotEqual(UserEntity.Status status) {
        return (Root<UserEntity> root, CriteriaQuery<?> query, CriteriaBuilder builder) ->
                builder.notEqual(root.get("status"), status.name());
    }

}

package br.com.occurrence.api.infrastructure.postgres.specification;

import br.com.occurrence.api.infrastructure.postgres.entity.DepartmentEntity;
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
public class TeamSpecifications {

    public static Specification<TeamEntity> nameLike(String name) {
        return (Root<TeamEntity> root, CriteriaQuery<?> query, CriteriaBuilder builder) ->
                builder.like(root.get("name"), "%" + name + "%");
    }

    public static Specification<TeamEntity> responsibleIdEqual(String responsibleId) {
        return (Root<TeamEntity> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> {
            Join<TeamEntity, UserEntity> userJoin = root.join("responsible");
            return builder.equal(userJoin.get("id"), UUID.fromString(responsibleId));
        };
    }

    public static Specification<TeamEntity> responsibleNameEqual(String responsibleName) {
        return (Root<TeamEntity> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> {
            Join<TeamEntity, UserEntity> userJoin = root.join("responsible");
            return builder.equal(userJoin.get("name"), responsibleName);
        };
    }

    public static Specification<TeamEntity> sectorIdEqual(String sectorId) {
        return (Root<TeamEntity> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> {
            Join<TeamEntity, DepartmentEntity> sectorJoin = root.join("sector");
            return builder.equal(sectorJoin.get("id"), UUID.fromString(sectorId));
        };
    }

    public static Specification<TeamEntity> statusEqual(TeamEntity.Status status) {
        return (Root<TeamEntity> root, CriteriaQuery<?> query, CriteriaBuilder builder) ->
                builder.equal(root.get("status"), status.name());
    }

    public static Specification<TeamEntity> statusNotEqual(TeamEntity.Status status) {
        return (Root<TeamEntity> root, CriteriaQuery<?> query, CriteriaBuilder builder) ->
                builder.notEqual(root.get("status"), status.name());
    }

}

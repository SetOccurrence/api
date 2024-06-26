package br.com.occurrence.api.infrastructure.postgres.specification;

import br.com.occurrence.api.infrastructure.postgres.entity.UnitEntity;
import br.com.occurrence.api.infrastructure.postgres.entity.UserEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;
import lombok.experimental.UtilityClass;
import org.springframework.data.jpa.domain.Specification;

import java.util.UUID;

@UtilityClass
public class UnitSpecifications {

    public static Specification<UnitEntity> nameLike(String name) {
        return (Root<UnitEntity> root, CriteriaQuery<?> query, CriteriaBuilder builder) ->
                builder.like(root.get("name"), "%" + name + "%");
    }

    public static Specification<UnitEntity> responsibleIdEqual(String responsibleId) {
        return (Root<UnitEntity> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> {
            Join<UnitEntity, UserEntity> userJoin = root.join("responsible");
            return builder.equal(userJoin.get("id"), UUID.fromString(responsibleId));
        };
    }

    public static Specification<UnitEntity> responsibleNameEqual(String responsibleName) {
        return (Root<UnitEntity> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> {
            Join<UnitEntity, UserEntity> userJoin = root.join("responsible");
            return builder.equal(userJoin.get("name"), responsibleName);
        };
    }

    public static Specification<UnitEntity> statusEqual(UnitEntity.Status status) {
        return (Root<UnitEntity> root, CriteriaQuery<?> query, CriteriaBuilder builder) ->
                builder.equal(root.get("status"), status.name());
    }

    public static Specification<UnitEntity> statusNotEqual(UnitEntity.Status status) {
        return (Root<UnitEntity> root, CriteriaQuery<?> query, CriteriaBuilder builder) ->
                builder.notEqual(root.get("status"), status.name());
    }

}

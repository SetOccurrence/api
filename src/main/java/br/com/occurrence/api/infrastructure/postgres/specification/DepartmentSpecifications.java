package br.com.occurrence.api.infrastructure.postgres.specification;

import br.com.occurrence.api.infrastructure.postgres.entity.DepartmentEntity;
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
public class DepartmentSpecifications {

    public static Specification<DepartmentEntity> nameLike(String name) {
        return (Root<DepartmentEntity> root, CriteriaQuery<?> query, CriteriaBuilder builder) ->
                builder.like(root.get("name"), "%" + name + "%");
    }

    public static Specification<DepartmentEntity> responsibleIdEqual(String responsibleId) {
        return (Root<DepartmentEntity> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> {
            Join<DepartmentEntity, UserEntity> userJoin = root.join("responsible");
            return builder.equal(userJoin.get("id"), UUID.fromString(responsibleId));
        };
    }

    public static Specification<DepartmentEntity> responsibleNameEqual(String responsibleName) {
        return (Root<DepartmentEntity> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> {
            Join<DepartmentEntity, UserEntity> userJoin = root.join("responsible");
            return builder.equal(userJoin.get("name"), responsibleName);
        };
    }

    public static Specification<DepartmentEntity> unitIdEqual(String unitId) {
        return (Root<DepartmentEntity> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> {
            Join<DepartmentEntity, UnitEntity> unitJoin = root.join("unit");
            return builder.equal(unitJoin.get("id"), UUID.fromString(unitId));
        };
    }

    public static Specification<DepartmentEntity> statusEqual(DepartmentEntity.Status status) {
        return (Root<DepartmentEntity> root, CriteriaQuery<?> query, CriteriaBuilder builder) ->
                builder.equal(root.get("status"), status.name());
    }

    public static Specification<DepartmentEntity> statusNotEqual(DepartmentEntity.Status status) {
        return (Root<DepartmentEntity> root, CriteriaQuery<?> query, CriteriaBuilder builder) ->
                builder.notEqual(root.get("status"), status.name());
    }

}

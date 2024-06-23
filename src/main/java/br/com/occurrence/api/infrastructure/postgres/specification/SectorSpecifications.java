package br.com.occurrence.api.infrastructure.postgres.specification;

import br.com.occurrence.api.infrastructure.postgres.entity.DepartmentEntity;
import br.com.occurrence.api.infrastructure.postgres.entity.SectorEntity;
import br.com.occurrence.api.infrastructure.postgres.entity.UserEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;
import lombok.experimental.UtilityClass;
import org.springframework.data.jpa.domain.Specification;

import java.util.UUID;

@UtilityClass
public class SectorSpecifications {

    public static Specification<SectorEntity> nameLike(String name) {
        return (Root<SectorEntity> root, CriteriaQuery<?> query, CriteriaBuilder builder) ->
                builder.like(root.get("name"), name);
    }

    public static Specification<SectorEntity> responsibleIdEqual(String responsibleId) {
        return (Root<SectorEntity> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> {
            Join<SectorEntity, UserEntity> userJoin = root.join("responsible");
            return builder.equal(userJoin.get("id"), UUID.fromString(responsibleId));
        };
    }

    public static Specification<SectorEntity> responsibleNameEqual(String responsibleName) {
        return (Root<SectorEntity> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> {
            Join<SectorEntity, UserEntity> userJoin = root.join("responsible");
            return builder.equal(userJoin.get("name"), responsibleName);
        };
    }

    public static Specification<SectorEntity> departmentIdEqual(String departmentId) {
        return (Root<SectorEntity> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> {
            Join<SectorEntity, DepartmentEntity> departmentJoin = root.join("department");
            return builder.equal(departmentJoin.get("id"), UUID.fromString(departmentId));
        };
    }

    public static Specification<SectorEntity> statusEqual(SectorEntity.Status status) {
        return (Root<SectorEntity> root, CriteriaQuery<?> query, CriteriaBuilder builder) ->
                builder.equal(root.get("status"), status.name());
    }

    public static Specification<SectorEntity> statusNotEqual(SectorEntity.Status status) {
        return (Root<SectorEntity> root, CriteriaQuery<?> query, CriteriaBuilder builder) ->
                builder.notEqual(root.get("status"), status.name());
    }

}

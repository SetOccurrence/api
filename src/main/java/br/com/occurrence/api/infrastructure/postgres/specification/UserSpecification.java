package br.com.occurrence.api.infrastructure.postgres.specification;

import br.com.occurrence.api.infrastructure.postgres.entity.UserEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class UserSpecification implements Specification<UserEntity> {

    private final List<Specification<UserEntity>> filters = new ArrayList<>();

    public void setSearch(String search) {
        filters.add(UserSpecifications.nameLike(search));
        filters.add(UserSpecifications.emailLike(search));
        filters.add(UserSpecifications.loginLike(search));
    }

    public void setStatus(UserEntity.Status status) {
        if (status == null) {
            return;
        }
        filters.add(UserSpecifications.statusEqual(status));
    }

    @Override
    public Predicate toPredicate(Root<UserEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if (filters.isEmpty()) {
            return criteriaBuilder.conjunction();  // retorna um predicado 'true' se não houver filtros
        }
        Specification<UserEntity> combinedSpecification = filters.stream()
                .reduce(Specification::and)
                .orElse(Specification.where(null));
        return combinedSpecification.toPredicate(root, query, criteriaBuilder);
    }

}

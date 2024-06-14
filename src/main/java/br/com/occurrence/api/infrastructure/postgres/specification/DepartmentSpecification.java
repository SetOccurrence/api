package br.com.occurrence.api.infrastructure.postgres.specification;

import br.com.occurrence.api.infrastructure.postgres.entity.DepartmentEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.apache.logging.log4j.util.Strings;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class DepartmentSpecification implements Specification<DepartmentEntity> {

    private final List<Specification<DepartmentEntity>> filters = new ArrayList<>();

    public void setName(String name) {
        if (Strings.isBlank(name)) {
            return;
        }
        filters.add(DepartmentSpecifications.nameLike(name));
    }

    public void setResponsibleId(String responsibleId) {
        if (Strings.isBlank(responsibleId)) {
            return;
        }
        filters.add(DepartmentSpecifications.responsibleIdEqual(responsibleId));
    }

    public void setResponsibleName(String responsibleName) {
        if (Strings.isBlank(responsibleName)) {
            return;
        }
        filters.add(DepartmentSpecifications.responsibleNameEqual(responsibleName));
    }

    public void setStatus(DepartmentEntity.Status status) {
        if (status == null) {
            return;
        }
        filters.add(DepartmentSpecifications.statusEqual(status));
    }

    @Override
    public Predicate toPredicate(Root<DepartmentEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if (filters.isEmpty()) {
            return criteriaBuilder.conjunction();  // retorna um predicado 'true' se não houver filtros
        }
        Specification<DepartmentEntity> combinedSpecification = filters.stream()
                .reduce(Specification::and)
                .orElse(Specification.where(null));
        return combinedSpecification.toPredicate(root, query, criteriaBuilder);
    }

}

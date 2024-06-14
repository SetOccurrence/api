package br.com.occurrence.api.infrastructure.postgres.specification;

import br.com.occurrence.api.infrastructure.postgres.entity.UnitEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.apache.logging.log4j.util.Strings;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class UnitSpecification implements Specification<UnitEntity> {

    private final List<Specification<UnitEntity>> filters = new ArrayList<>();

    public void setName(String name) {
        if (Strings.isBlank(name)) {
            return;
        }
        filters.add(UnitSpecifications.nameLike(name));
    }

    public void setResponsibleId(String responsibleId) {
        if (Strings.isBlank(responsibleId)) {
            return;
        }
        filters.add(UnitSpecifications.responsibleIdEqual(responsibleId));
    }

    public void setResponsibleName(String responsibleName) {
        if (Strings.isBlank(responsibleName)) {
            return;
        }
        filters.add(UnitSpecifications.responsibleNameEqual(responsibleName));
    }

    public void setStatus(UnitEntity.Status status) {
        if (status == null) {
            return;
        }
        filters.add(UnitSpecifications.statusEqual(status));
    }

    @Override
    public Predicate toPredicate(Root<UnitEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if (filters.isEmpty()) {
            return criteriaBuilder.conjunction();  // retorna um predicado 'true' se não houver filtros
        }
        Specification<UnitEntity> combinedSpecification = filters.stream()
                .reduce(Specification::and)
                .orElse(Specification.where(null));
        return combinedSpecification.toPredicate(root, query, criteriaBuilder);
    }

}

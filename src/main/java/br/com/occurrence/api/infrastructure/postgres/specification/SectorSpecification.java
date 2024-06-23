package br.com.occurrence.api.infrastructure.postgres.specification;

import br.com.occurrence.api.infrastructure.postgres.entity.SectorEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.apache.logging.log4j.util.Strings;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class SectorSpecification implements Specification<SectorEntity> {

    private final List<Specification<SectorEntity>> filters = new ArrayList<>();

    public void setName(String name) {
        if (Strings.isBlank(name)) {
            return;
        }
        filters.add(SectorSpecifications.nameLike(name));
    }

    public void setResponsibleId(String responsibleId) {
        if (Strings.isBlank(responsibleId)) {
            return;
        }
        filters.add(SectorSpecifications.responsibleIdEqual(responsibleId));
    }

    public void setResponsibleName(String responsibleName) {
        if (Strings.isBlank(responsibleName)) {
            return;
        }
        filters.add(SectorSpecifications.responsibleNameEqual(responsibleName));
    }

    public void setDepartmentId(String departmentId) {
        if (Strings.isBlank(departmentId)) {
            return;
        }
        filters.add(SectorSpecifications.departmentIdEqual(departmentId));
    }

    public void setStatus(SectorEntity.Status status) {
        if (status == null) {
            return;
        }
        filters.add(SectorSpecifications.statusEqual(status));
    }

    @Override
    public Predicate toPredicate(Root<SectorEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if (filters.isEmpty()) {
            return criteriaBuilder.conjunction();  // retorna um predicado 'true' se não houver filtros
        }
        Specification<SectorEntity> combinedSpecification = filters.stream()
                .reduce(Specification::and)
                .orElse(Specification.where(null));
        return combinedSpecification.toPredicate(root, query, criteriaBuilder);
    }

}

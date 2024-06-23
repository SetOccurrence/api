package br.com.occurrence.api.infrastructure.postgres.specification;

import br.com.occurrence.api.infrastructure.postgres.entity.TeamEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.apache.logging.log4j.util.Strings;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class TeamSpecification implements Specification<TeamEntity> {

    private final List<Specification<TeamEntity>> filters = new ArrayList<>();

    public void setName(String name) {
        if (Strings.isBlank(name)) {
            return;
        }
        filters.add(TeamSpecifications.nameLike(name));
    }

    public void setResponsibleId(String responsibleId) {
        if (Strings.isBlank(responsibleId)) {
            return;
        }
        filters.add(TeamSpecifications.responsibleIdEqual(responsibleId));
    }

    public void setResponsibleName(String responsibleName) {
        if (Strings.isBlank(responsibleName)) {
            return;
        }
        filters.add(TeamSpecifications.responsibleNameEqual(responsibleName));
    }

    public void setSectorId(String sectorId) {
        if (Strings.isBlank(sectorId)) {
            return;
        }
        filters.add(TeamSpecifications.sectorIdEqual(sectorId));
    }

    public void setStatus(TeamEntity.Status status) {
        if (status == null) {
            return;
        }
        filters.add(TeamSpecifications.statusEqual(status));
    }

    @Override
    public Predicate toPredicate(Root<TeamEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if (filters.isEmpty()) {
            return criteriaBuilder.conjunction();  // retorna um predicado 'true' se não houver filtros
        }
        Specification<TeamEntity> combinedSpecification = filters.stream()
                .reduce(Specification::and)
                .orElse(Specification.where(null));
        return combinedSpecification.toPredicate(root, query, criteriaBuilder);
    }

}

package br.com.occurrence.api.infrastructure.mongodb.specification;

import br.com.occurrence.api.domain.model.occurrence.OccurrenceKind;
import org.apache.logging.log4j.util.Strings;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class OccurrenceKindEntityCriteria {

    private final List<Criteria> filters = new ArrayList<>();

    public void setSearch(String search) {
        if (Strings.isBlank(search)) {
            return;
        }
        filters.add(OccurrenceKindEntitySpecifications.search(search));
    }

    public Query getQuery() {
        if (CollectionUtils.isEmpty(filters)) {
            return new Query(new Criteria());
        }
        return new Query(new Criteria().andOperator(filters.toArray(new Criteria[0])));
    }

}


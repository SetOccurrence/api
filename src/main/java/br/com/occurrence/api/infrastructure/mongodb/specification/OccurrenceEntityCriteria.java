package br.com.occurrence.api.infrastructure.mongodb.specification;

import br.com.occurrence.api.domain.service.UserReadService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OccurrenceEntityCriteria {

    private final List<Criteria> filters = new ArrayList<>();

    public void setSearch(String search) {
        if (Strings.isBlank(search)) {
            return;
        }
        filters.add(OccurrenceEntitySpecifications.search(search));
    }

    public void setPending(boolean pending) {
        if (!pending) {
            return;
        }
        filters.add(OccurrenceEntitySpecifications.pending());
    }

    public void setMyOccurrences(boolean myOccurrences) {
        if (!myOccurrences) {
            return;
        }
        filters.add(OccurrenceEntitySpecifications.requesterId(UserReadService.me().getId()));
    }

    public void setRequesterId(UUID requesterId) {
        if (requesterId == null) {
            return;
        }
        filters.add(OccurrenceEntitySpecifications.requesterId(requesterId));
    }

    public void setStartDateAt(LocalDateTime startDateAt) {
        if (startDateAt == null) {
            return;
        }
        filters.add(OccurrenceEntitySpecifications.afterDate(startDateAt));
    }

    public void setEndDateAt(LocalDateTime endDateAt) {
        if (endDateAt == null) {
            return;
        }
        filters.add(OccurrenceEntitySpecifications.beforeDate(endDateAt));
    }

    public Query getQuery() {
        if (CollectionUtils.isEmpty(filters)) {
            return new Query(new Criteria());
        }
        return new Query(new Criteria().andOperator(filters.toArray(new Criteria[0])));
    }

}


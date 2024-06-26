package br.com.occurrence.api.infrastructure.mongodb.specification;

import br.com.occurrence.api.domain.model.occurrence.Occurrence;
import lombok.experimental.UtilityClass;
import org.springframework.data.mongodb.core.query.Criteria;

import java.time.LocalDateTime;
import java.util.UUID;

@UtilityClass
public class OccurrenceEntitySpecifications {

    public static Criteria search(String search) {
        return new Criteria().orOperator(
            Criteria.where("name").regex(search, "i"),
            Criteria.where("occurrenceKind.name").regex(search, "i"),
            Criteria.where("occurrenceKind.prefix").regex(search, "i"),
            Criteria.where("occurrenceKind.category").regex(search, "i")
        );
    }

    public static Criteria pending() {
        return Criteria.where("status").is(Occurrence.Status.OPEN.name());
    }

    public static Criteria requesterId(UUID requesterId) {
        return Criteria.where("createdBy").is(requesterId.toString());
    }

    public static Criteria afterDate(LocalDateTime afterDate) {
        return Criteria.where("createdAt").gte(afterDate);
    }

    public static Criteria beforeDate(LocalDateTime beforeDate) {
        return Criteria.where("createdAt").lte(beforeDate);
    }

}

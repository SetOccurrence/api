package br.com.occurrence.api.infrastructure.mongodb.specification;

import lombok.experimental.UtilityClass;
import org.springframework.data.mongodb.core.query.Criteria;

@UtilityClass
public class OccurrenceKindEntitySpecifications {

    public static Criteria search(String search) {
        return new Criteria().orOperator(
            Criteria.where("name").regex(search, "i"),
            Criteria.where("prefix").regex(search, "i"),
            Criteria.where("category").regex(search, "i")
        );
    }

}

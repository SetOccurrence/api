package br.com.occurrence.api.infrastructure.mongodb.entity;

import br.com.occurrence.api.domain.model.occurrence.OccurrenceKind;
import br.com.occurrence.api.domain.model.occurrence.commons.flow.FlowMap;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document(collection = "occurrences-kind")
public class OccurrenceKindEntity {

    @Id
    private String id;
    private String name;
    private String prefix;
    private String description;
    private String category;
    private OccurrenceKind.Status status = OccurrenceKind.Status.ACTIVE;
    private FlowMap flowMap;

}

package br.com.occurrence.api.infrastructure.mongodb.entity;

import br.com.occurrence.api.domain.model.occurrence.Occurrence;
import br.com.occurrence.api.domain.model.occurrence.commons.Comment;
import br.com.occurrence.api.domain.model.occurrence.commons.flow.Flow;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@Document(collection = "occurrences")
public class OccurrenceEntity {

    @Id
    private String id;
    private String name;
    private String occurrenceKindId;
    private Occurrence.Status status;
    private Flow flow;
    private List<Comment> comments;
    private String createdBy;
    private LocalDateTime createdAt;

}

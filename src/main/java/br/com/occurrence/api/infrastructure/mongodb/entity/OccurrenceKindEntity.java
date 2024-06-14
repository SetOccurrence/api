package br.com.occurrence.api.infrastructure.mongodb.entity;

import br.com.occurrence.api.domain.model.occurrence.commons.step.Step;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Setter
@Getter
//@Entity
//@Document(collection = "occurrences-kind")
public class OccurrenceKindEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String prefix;
    private Integer version;
    private String description;
    private String category;
    private List<Step> steps;

}

package br.com.occurrence.api.infrastructure.mongodb.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Setter
@Getter
//@Entity
//@Document(collection = "occurrences")
public class OccurrenceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private int instance;

    //public String getName() {
    //    return String.format("%s-%04d", occurrenceKind.getPrefix(), instance);
    //}

}

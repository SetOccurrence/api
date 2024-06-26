package br.com.occurrence.api.domain.model.occurrence;

import br.com.occurrence.api.domain.model.occurrence.commons.flow.FlowMap;
import br.com.occurrence.api.domain.model.organization.User;
import br.com.occurrence.api.domain.util.Auditable;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode(of = {"id"}, callSuper = false)
public class OccurrenceKind {

    private String id;
    private String name;
    private String icon;
    private String color;
    private String prefix;
    private long instances;
    private String description;
    private String category;
    private Status status = Status.ACTIVE;
    private FlowMap flowMap;
    private String createdBy;
    private LocalDateTime createdAt;

    @Getter
    @AllArgsConstructor
    public enum Status {
        ACTIVE("Active"),
        INACTIVE("Inactive"),
        DELETED("Deleted");

        private final String description;
    }

    public String getOccurrenceName() {
        return String.format("%s-%04d", prefix, instances);
    }

}

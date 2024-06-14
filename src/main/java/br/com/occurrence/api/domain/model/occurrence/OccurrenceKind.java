package br.com.occurrence.api.domain.model.occurrence;

import br.com.occurrence.api.domain.model.occurrence.commons.flow.FlowMap;
import br.com.occurrence.api.domain.model.organization.User;
import br.com.occurrence.api.domain.util.Auditable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode(of = {"id"}, callSuper = false)
public class OccurrenceKind extends Auditable<User> {

    private UUID id;
    private String name;
    private String prefix;
    private String description;
    private String category;
    private Status status = Status.ACTIVE;
    private FlowMap flowMap;

    @Getter
    @AllArgsConstructor
    public enum Status {
        ACTIVE("Active"),
        INACTIVE("Inactive"),
        DELETED("Deleted");

        private final String description;
    }

}

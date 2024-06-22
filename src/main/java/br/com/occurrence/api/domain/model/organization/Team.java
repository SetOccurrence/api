package br.com.occurrence.api.domain.model.organization;

import br.com.occurrence.api.domain.model.organization.commons.Contact;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class Team implements Entity {

    private UUID id;
    private String name;
    private String description;
    private User responsible;
    private Contact contact;
    private List<User> users;
    private Sector sector;
    private Status status = Status.ACTIVE;
    private String createdBy;
    private LocalDateTime createdAt;
    private String updatedBy;
    private LocalDateTime updatedAt;

    @Override
    public Type getType() {
        return Type.TEAM;
    }

    @Getter
    @AllArgsConstructor
    public enum Status {
        ACTIVE("Active"),
        INACTIVE("Inactive"),
        DELETED("Deleted");

        private final String description;
    }

}

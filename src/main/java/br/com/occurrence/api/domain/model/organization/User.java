package br.com.occurrence.api.domain.model.organization;

import br.com.occurrence.api.domain.model.organization.commons.Contact;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private UUID id;
    private String name;
    private String email;
    private String login;
    private Contact contact;
    private Team team;
    private Status status = Status.ACTIVE;
    private String createdBy;
    private LocalDateTime createdAt;
    private String updatedBy;
    private LocalDateTime updatedAt;

    @Getter
    @AllArgsConstructor
    public enum Status {
        ACTIVE("Active"),
        INACTIVE("Inactive"),
        BLOCKED("Blocked"),
        DELETED("Deleted");

        private final String description;
    }

}

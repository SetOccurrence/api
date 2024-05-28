package br.com.occurrence.api.domain.model;

import br.com.occurrence.api.domain.model.commons.Contact;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
public class User {

    private UUID id;
    private String name;
    private String email;
    private String login;
    private Contact contact;
    private Status status = Status.PENDING;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;

    @Getter
    @AllArgsConstructor
    public enum Status {
        ACTIVE("Active"),
        INACTIVE("Inactive"),
        PENDING("Pending Activation"),
        BLOCKED("Blocked"),
        DELETED("Deleted");

        private final String description;
    }

}

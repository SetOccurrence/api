package br.com.occurrence.api.domain.model.organization;

import br.com.occurrence.api.domain.model.organization.commons.Address;
import br.com.occurrence.api.domain.model.organization.commons.Contact;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class Unit {

    private UUID id;
    private String name;
    private String description;
    private User responsible;
    private Address address;
    private Contact contact;
    private List<Department> departments;
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
        DELETED("Deleted");

        private final String description;
    }

}

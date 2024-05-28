package br.com.occurrence.api.infrastructure.postgres.entity;

import br.com.occurrence.api.domain.util.Auditable;
import br.com.occurrence.api.infrastructure.postgres.entity.commons.ContactEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "users")
public class UserEntity extends Auditable<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(length = 80, nullable = false)
    private String name;

    @Column(length = 80, unique = true, nullable = false)
    private String email;

    @Column(length = 40, unique = true, nullable = false)
    private String login;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(length = 80, nullable = false)
    @ElementCollection
    private Set<String> roles;

    @Embedded
    private ContactEntity contact;

    public enum Status {
        ACTIVE,
        INACTIVE,
        PENDING,
        BLOCKED,
        DELETED;
    }

}

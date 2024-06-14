package br.com.occurrence.api.infrastructure.postgres.entity;

import br.com.occurrence.api.domain.util.Auditable;
import br.com.occurrence.api.infrastructure.postgres.entity.commons.ContactEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "teams")
public class TeamEntity extends Auditable<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(length = 80, nullable = false)
    private String name;

    @Column(length = 80)
    private String description;

    @ManyToOne
    @JoinColumn(name = "sector_id")
    private SectorEntity sector;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity responsible;

    @Embedded
    private ContactEntity contact;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "users_team",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "team_id")
    )
    private List<UserEntity> users;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
        ACTIVE,
        INACTIVE,
        DELETED;
    }

}

package br.com.occurrence.api.infrastructure.postgres.entity;

import br.com.occurrence.api.domain.util.Auditable;
import br.com.occurrence.api.infrastructure.postgres.entity.commons.AddressEntity;
import br.com.occurrence.api.infrastructure.postgres.entity.commons.ContactEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "units")
public class UnitEntity extends Auditable<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(length = 80, nullable = false)
    private String name;

    @Column(length = 80)
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity responsible;

    @Embedded
    private AddressEntity address;

    @Embedded
    private ContactEntity contact;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "departments_unit",
        joinColumns = @JoinColumn(name = "department_id"),
        inverseJoinColumns = @JoinColumn(name = "unit_id")
    )
    private List<DepartmentEntity> departments;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
        ACTIVE,
        INACTIVE,
        DELETED;
    }

}

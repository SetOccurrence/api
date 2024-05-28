package br.com.occurrence.api.infrastructure.postgres.entity.commons;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class ContactEntity {

    @Column(name = "contactEmail", length = 80)
    private String email;

    @Column(name = "contactPhoneNumber", length = 40)
    private String phoneNumber;

    @Column(name = "contactDescription")
    private String description;

}

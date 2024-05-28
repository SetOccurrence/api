package br.com.occurrence.api.infrastructure.postgres.entity.commons;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class AddressEntity {

    @Column(name = "addressStreet", length = 80)
    private String street;

    @Column(name = "addressNumber")
    private Integer number;

    @Column(name = "addressComplement", length = 60)
    private String complement;

    @Column(name = "addressNeighborhood", length = 60)
    private String neighborhood;

    @Column(name = "addressCity", length = 60)
    private String city;

    @Column(name = "addressState", length = 60)
    private String state;

    @Column(name = "addressCountryAcronym", length = 2)
    private String countryAcronym;

    @Column(name = "addressCountry", length = 60)
    private String country;

    @Column(name = "addressCep", length = 10)
    private String cep;

}

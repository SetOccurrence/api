package br.com.occurrence.api.app.api.dto.organization.commons;

public record AddressDto(
        String street,
        Integer number,
        String complement,
        String neighborhood,
        String city,
        String state,
        String country,
        String cep) {
}



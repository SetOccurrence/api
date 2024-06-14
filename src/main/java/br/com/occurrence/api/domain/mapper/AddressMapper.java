package br.com.occurrence.api.domain.mapper;

import br.com.occurrence.api.app.api.dto.organization.commons.AddressDto;
import br.com.occurrence.api.domain.model.organization.commons.Address;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AddressMapper {

    public static Address toAddress(AddressDto addressDto) {
        if (addressDto == null) {
            return null;
        }
        Address address = new Address();
        address.setStreet(addressDto.street());
        address.setNumber(addressDto.number());
        address.setComplement(addressDto.complement());
        address.setNeighborhood(addressDto.neighborhood());
        address.setCity(addressDto.city());
        address.setState(addressDto.state());
        address.setCountry(addressDto.country());
        address.setCep(addressDto.cep());
        return address;
    }

    public static AddressDto toAddressDto(Address address) {
        if (address == null) {
            return null;
        }
        return new AddressDto(
            address.getStreet(),
            address.getNumber(),
            address.getComplement(),
            address.getNeighborhood(),
            address.getCity(),
            address.getState(),
            address.getCountry(),
            address.getCep()
        );
    }

}

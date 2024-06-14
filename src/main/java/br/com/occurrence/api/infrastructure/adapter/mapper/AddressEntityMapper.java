package br.com.occurrence.api.infrastructure.adapter.mapper;

import br.com.occurrence.api.domain.model.organization.commons.Address;
import br.com.occurrence.api.infrastructure.postgres.entity.commons.AddressEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AddressEntityMapper {

    public static Address toAddress(AddressEntity addressEntity) {
        if (addressEntity == null) {
            return null;
        }
        Address address = new Address();
        address.setStreet(addressEntity.getStreet());
        address.setNumber(addressEntity.getNumber());
        address.setComplement(addressEntity.getComplement());
        address.setNeighborhood(addressEntity.getNeighborhood());
        address.setCity(addressEntity.getCity());
        address.setState(addressEntity.getState());
        address.setCountry(addressEntity.getCountry());
        address.setCep(addressEntity.getCep());
        return address;
    }

    public static AddressEntity toAddressEntity(Address address) {
        if (address == null) {
            return null;
        }
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setStreet(address.getStreet());
        addressEntity.setNumber(address.getNumber());
        addressEntity.setComplement(address.getComplement());
        addressEntity.setNeighborhood(address.getNeighborhood());
        addressEntity.setCity(address.getCity());
        addressEntity.setState(address.getState());
        addressEntity.setCountry(address.getCountry());
        addressEntity.setCep(address.getCep());
        return addressEntity;
    }

}

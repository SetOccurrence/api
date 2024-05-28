package br.com.occurrence.api.infrastructure.adapter.mapper;

import br.com.occurrence.api.domain.model.commons.Address;
import br.com.occurrence.api.infrastructure.postgres.entity.commons.AddressEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AddressEntityMapper {

    AddressEntity toAddressEntity(Address address);
    Address toAddress(AddressEntity entity);

}

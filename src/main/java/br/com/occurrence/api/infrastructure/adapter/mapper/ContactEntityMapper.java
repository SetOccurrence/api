package br.com.occurrence.api.infrastructure.adapter.mapper;

import br.com.occurrence.api.domain.model.commons.Contact;
import br.com.occurrence.api.infrastructure.postgres.entity.commons.ContactEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ContactEntityMapper {

    ContactEntity toContactEntity(Contact contact);
    Contact toContact(ContactEntity entity);

}

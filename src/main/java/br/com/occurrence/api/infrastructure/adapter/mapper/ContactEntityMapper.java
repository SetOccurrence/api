package br.com.occurrence.api.infrastructure.adapter.mapper;

import br.com.occurrence.api.domain.model.organization.commons.Contact;
import br.com.occurrence.api.infrastructure.postgres.entity.commons.ContactEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ContactEntityMapper {

    public static Contact toContact(ContactEntity contactEntity) {
        if (contactEntity == null) {
            return null;
        }
        Contact contact = new Contact();
        contact.setEmail(contactEntity.getEmail());
        contact.setPhoneNumber(contactEntity.getPhoneNumber());
        contact.setDescription(contactEntity.getDescription());
        return contact;
    }

    public static ContactEntity toContactEntity(Contact contact) {
        if (contact == null) {
            return null;
        }
        ContactEntity contactEntity = new ContactEntity();
        contactEntity.setEmail(contact.getEmail());
        contactEntity.setPhoneNumber(contact.getPhoneNumber());
        contactEntity.setDescription(contact.getDescription());
        return contactEntity;
    }

}

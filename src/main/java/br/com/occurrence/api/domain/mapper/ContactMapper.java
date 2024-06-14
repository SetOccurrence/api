package br.com.occurrence.api.domain.mapper;

import br.com.occurrence.api.app.api.dto.organization.commons.ContactDto;
import br.com.occurrence.api.domain.model.organization.commons.Contact;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ContactMapper {

    public static Contact toContact(ContactDto contactDto) {
        if (contactDto == null) {
            return null;
        }
        Contact contact = new Contact();
        contact.setEmail(contactDto.email());
        contact.setPhoneNumber(contactDto.phoneNumber());
        contact.setDescription(contactDto.description());
        return contact;
    }

    public static ContactDto toContactDto(Contact contact) {
        if (contact == null) {
            return null;
        }
        return new ContactDto(
            contact.getEmail(),
            contact.getPhoneNumber(),
            contact.getDescription()
        );
    }


}

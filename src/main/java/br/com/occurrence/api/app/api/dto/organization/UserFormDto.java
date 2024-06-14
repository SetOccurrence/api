package br.com.occurrence.api.app.api.dto.organization;

import br.com.occurrence.api.app.api.dto.organization.commons.ContactDto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record UserFormDto(
        @NotBlank @Size(max = 80) String name,
        @Email @NotBlank @Size(max = 80) String email,
        @NotBlank @Size(max = 40) String login,
        @NotNull UUID teamId,
        ContactDto contact) {
}
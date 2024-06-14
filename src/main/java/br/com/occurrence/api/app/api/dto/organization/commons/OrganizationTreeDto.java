package br.com.occurrence.api.app.api.dto.organization.commons;

import java.util.List;

public record OrganizationTreeDto(List<OrganizationTreeItemDto> items) {

    public record OrganizationTreeItemDto(EntityDto entity, List<OrganizationTreeItemDto> children) {
    }

}

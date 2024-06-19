package br.com.occurrence.api.app.api.dto.organization.commons;

import br.com.occurrence.api.app.api.dto.organization.UserDto;

import java.util.List;

public record OrganizationTreeDto(List<OrganizationTreeItemDto> treeItems, List<UserDto> noRelationUsers) {

    public record OrganizationTreeItemDto(EntityDto entity, List<OrganizationTreeItemDto> children) {
    }

}

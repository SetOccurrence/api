package br.com.occurrence.api.app.api.dto.organization.commons;

import java.util.UUID;

public record EntityDto(UUID id, String name, Type type) {

    public enum Type {
        UNIT,
        DEPARTMENT,
        SECTOR,
        TEAM,
        USER
    }

}

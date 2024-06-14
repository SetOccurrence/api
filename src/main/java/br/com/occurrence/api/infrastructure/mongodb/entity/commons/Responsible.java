package br.com.occurrence.api.infrastructure.mongodb.entity.commons;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Responsible {

    private Type entityType;
    private UUID entityId;

    public enum Type {
        USER,
        TEAM,
        SECTOR,
        DEPARTMENT,
        UNIT
    }

}

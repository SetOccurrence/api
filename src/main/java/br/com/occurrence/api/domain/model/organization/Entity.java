package br.com.occurrence.api.domain.model.organization;

import java.util.UUID;

public interface Entity {

   UUID getId();
   String getName();
   Type getType();

    public enum Type {
        UNIT,
        DEPARTMENT,
        SECTOR,
        TEAM,
        USER
    }


}

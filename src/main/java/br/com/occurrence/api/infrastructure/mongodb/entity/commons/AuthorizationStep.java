package br.com.occurrence.api.infrastructure.mongodb.entity.commons;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AuthorizationStep extends Step {

    @Override
    public Type getType() {
        return Type.AUTHORIZATION;
    }

}

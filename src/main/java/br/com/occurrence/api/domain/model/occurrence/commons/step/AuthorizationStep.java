package br.com.occurrence.api.domain.model.occurrence.commons.step;

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

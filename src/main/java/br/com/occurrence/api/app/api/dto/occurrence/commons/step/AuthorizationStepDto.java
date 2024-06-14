package br.com.occurrence.api.app.api.dto.occurrence.commons.step;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AuthorizationStepDto extends StepDto {

    @Override
    public Type getType() {
        return Type.AUTHORIZATION;
    }

}

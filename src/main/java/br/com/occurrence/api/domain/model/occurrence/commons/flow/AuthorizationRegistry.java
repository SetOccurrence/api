package br.com.occurrence.api.domain.model.occurrence.commons.flow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthorizationRegistry extends FlowRegistry {

    private Action action;
    private String observation;

    @Override
    public Type getType() {
        return Type.AUTHORIZATION;
    }

    public enum Action {
        APPROVE,
        REJECT,
        REVIEW
    }

}

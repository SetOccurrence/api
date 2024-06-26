package br.com.occurrence.api.domain.model.occurrence.commons.flow;

import br.com.occurrence.api.domain.model.occurrence.commons.step.Step;
import br.com.occurrence.api.domain.model.organization.User;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public abstract class FlowRegistry {

    protected Step step;
    protected User resolver;
    protected LocalDateTime resolvedAt;

    public abstract Type getType();

    public enum Type {
        AUTHORIZATION,
        FORM
    }

}

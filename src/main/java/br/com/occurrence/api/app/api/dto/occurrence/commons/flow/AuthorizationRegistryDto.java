package br.com.occurrence.api.app.api.dto.occurrence.commons.flow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthorizationRegistryDto extends FlowRegistryDto {

    private Action action;
    private String observation;

    public enum Action {
        APPROVE,
        REJECT,
        REVIEW
    }

}

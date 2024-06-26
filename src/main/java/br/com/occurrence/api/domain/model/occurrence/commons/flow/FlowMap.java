package br.com.occurrence.api.domain.model.occurrence.commons.flow;

import br.com.occurrence.api.domain.model.occurrence.commons.step.FormStep;
import br.com.occurrence.api.domain.model.occurrence.commons.step.Step;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FlowMap {

    private LinkedList<Step> steps;

    public FormStep getFirstStep() {
        return (FormStep) steps.get(0);
    }

}

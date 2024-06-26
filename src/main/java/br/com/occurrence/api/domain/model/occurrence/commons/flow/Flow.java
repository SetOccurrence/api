package br.com.occurrence.api.domain.model.occurrence.commons.flow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Flow {

    private List<FlowRegistry> registries;
    private int stepIndex;

    public void addFlowRegistry(FlowRegistry flowRegistry, boolean next) {
        if (registries == null) {
            registries = new LinkedList<>();
        }
        registries.add(flowRegistry);
        if (next) {
            stepIndex++;
        } else {
            stepIndex--;
        }
    }

}

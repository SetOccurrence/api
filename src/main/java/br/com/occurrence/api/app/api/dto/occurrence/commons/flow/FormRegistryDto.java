package br.com.occurrence.api.app.api.dto.occurrence.commons.flow;

import br.com.occurrence.api.app.api.dto.occurrence.commons.form.answer.AnswerDto;
import br.com.occurrence.api.domain.model.occurrence.commons.flow.FlowRegistry;
import br.com.occurrence.api.domain.model.occurrence.commons.form.Form;
import br.com.occurrence.api.domain.model.occurrence.commons.step.FormStep;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FormRegistryDto extends FlowRegistry {

    private List<AnswerDto> answers;

    public Form getForm() {
        return ((FormStep) super.step).getForm();
    }

}

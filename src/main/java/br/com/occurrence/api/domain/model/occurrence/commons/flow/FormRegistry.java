package br.com.occurrence.api.domain.model.occurrence.commons.flow;

import br.com.occurrence.api.domain.model.occurrence.commons.form.Form;
import br.com.occurrence.api.domain.model.occurrence.commons.form.answer.Answer;
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
public class FormRegistry extends FlowRegistry {

    private List<Answer> answers;

    public Form getForm() {
        return ((FormStep) super.step).getForm();
    }

    @Override
    public Type getType() {
        return Type.FORM;
    }

}

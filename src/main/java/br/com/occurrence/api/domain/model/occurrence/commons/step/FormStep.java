package br.com.occurrence.api.domain.model.occurrence.commons.step;

import br.com.occurrence.api.domain.model.occurrence.commons.form.Form;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FormStep extends Step {

    private Form form;

    @Override
    public Type getType() {
        return Type.FORM;
    }

}

package br.com.occurrence.api.app.api.dto.occurrence.commons.step;

import br.com.occurrence.api.app.api.dto.occurrence.commons.form.FormDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FormStepDto extends StepDto {

    private FormDto form;

    @Override
    public Type getType() {
        return Type.FORM;
    }

}

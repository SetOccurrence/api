package br.com.occurrence.api.domain.model.occurrence.commons.form.question;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CheckBoxQuestion extends Question {

    private String label;

    @Override
    public Type getType() {
        return Type.CHECK_BOX;
    }

}

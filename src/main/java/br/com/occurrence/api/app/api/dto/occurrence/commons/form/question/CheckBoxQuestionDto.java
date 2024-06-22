package br.com.occurrence.api.app.api.dto.occurrence.commons.form.question;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CheckBoxQuestionDto extends QuestionDto {

    private String label;

    @Override
    public Type getType() {
        return Type.CHECK_BOX;
    }

}

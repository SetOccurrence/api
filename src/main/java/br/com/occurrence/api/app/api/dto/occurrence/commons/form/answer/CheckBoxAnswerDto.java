package br.com.occurrence.api.app.api.dto.occurrence.commons.form.answer;

import br.com.occurrence.api.app.api.dto.occurrence.commons.form.question.CheckBoxQuestionDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CheckBoxAnswerDto extends AnswerDto {

    private boolean checked;

    public CheckBoxAnswerDto(CheckBoxQuestionDto question) {
        super(question);
    }

}

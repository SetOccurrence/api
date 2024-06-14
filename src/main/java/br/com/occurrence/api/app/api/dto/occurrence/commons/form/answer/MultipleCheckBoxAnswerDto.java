package br.com.occurrence.api.app.api.dto.occurrence.commons.form.answer;

import br.com.occurrence.api.app.api.dto.occurrence.commons.form.question.MultipleCheckBoxQuestionDto;
import br.com.occurrence.api.domain.model.occurrence.commons.form.answer.Answer;
import br.com.occurrence.api.domain.model.occurrence.commons.form.question.MultipleCheckBoxQuestion;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MultipleCheckBoxAnswerDto extends AnswerDto {

    private boolean[] checkboxes;

    public MultipleCheckBoxAnswerDto(MultipleCheckBoxQuestionDto question) {
        super(question);
    }

}

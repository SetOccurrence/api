package br.com.occurrence.api.app.api.dto.occurrence.commons.form.answer;

import br.com.occurrence.api.app.api.dto.occurrence.commons.form.question.MultipleCheckBoxGridQuestionDto;
import br.com.occurrence.api.domain.model.occurrence.commons.form.answer.Answer;
import br.com.occurrence.api.domain.model.occurrence.commons.form.question.MultipleCheckBoxGridQuestion;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MultipleCheckBoxGridAnswerDto extends AnswerDto {

    private boolean[][] checkboxes;

    public MultipleCheckBoxGridAnswerDto(MultipleCheckBoxGridQuestionDto question) {
        super(question);
    }

}

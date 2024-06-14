package br.com.occurrence.api.app.api.dto.occurrence.commons.form.answer;

import br.com.occurrence.api.app.api.dto.occurrence.commons.form.question.MultipleChoiceQuestionDto;
import br.com.occurrence.api.domain.model.occurrence.commons.form.answer.Answer;
import br.com.occurrence.api.domain.model.occurrence.commons.form.question.MultipleChoiceQuestion;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MultipleChoiceAnswerDto extends AnswerDto {

    private boolean[] choices;

    public MultipleChoiceAnswerDto(MultipleChoiceQuestionDto question) {
        super(question);
    }

}

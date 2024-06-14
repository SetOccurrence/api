package br.com.occurrence.api.app.api.dto.occurrence.commons.form.answer;

import br.com.occurrence.api.app.api.dto.occurrence.commons.form.question.MultipleChoiceGridQuestionDto;
import br.com.occurrence.api.domain.model.occurrence.commons.form.answer.Answer;
import br.com.occurrence.api.domain.model.occurrence.commons.form.question.MultipleChoiceGridQuestion;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MultipleChoiceGridAnswerDto extends AnswerDto {

    private boolean[][] choices;

    public MultipleChoiceGridAnswerDto(MultipleChoiceGridQuestionDto question) {
        super(question);
    }

}

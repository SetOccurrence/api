package br.com.occurrence.api.app.api.dto.occurrence.commons.form.answer;

import br.com.occurrence.api.app.api.dto.occurrence.commons.form.question.LongTextQuestionDto;
import br.com.occurrence.api.domain.model.occurrence.commons.form.answer.Answer;
import br.com.occurrence.api.domain.model.occurrence.commons.form.question.LongTextQuestion;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LongTextAnswerDto extends AnswerDto {

    private String answer;

    public LongTextAnswerDto(LongTextQuestionDto question) {
        super(question);
    }

}

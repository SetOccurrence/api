package br.com.occurrence.api.app.api.dto.occurrence.commons.form.answer;

import br.com.occurrence.api.app.api.dto.occurrence.commons.form.question.ShortTextQuestionDto;
import br.com.occurrence.api.domain.model.occurrence.commons.form.answer.Answer;
import br.com.occurrence.api.domain.model.occurrence.commons.form.question.ShortTextQuestion;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShortTextAnswerDto extends AnswerDto {

    private String answer;

    public ShortTextAnswerDto(ShortTextQuestionDto question) {
        super(question);
    }

}

package br.com.occurrence.api.app.api.dto.occurrence.commons.form.answer;

import br.com.occurrence.api.app.api.dto.occurrence.commons.form.question.LinearScaleQuestionDto;
import br.com.occurrence.api.domain.model.occurrence.commons.form.answer.Answer;
import br.com.occurrence.api.domain.model.occurrence.commons.form.question.LinearScaleQuestion;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LinearScaleAnswerDto extends AnswerDto {

    private int scaleIndex;

    public LinearScaleAnswerDto(LinearScaleQuestionDto question) {
        super(question);
    }

}

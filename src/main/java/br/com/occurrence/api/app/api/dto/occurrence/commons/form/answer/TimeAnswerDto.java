package br.com.occurrence.api.app.api.dto.occurrence.commons.form.answer;

import br.com.occurrence.api.app.api.dto.occurrence.commons.form.question.TimeQuestionDto;
import br.com.occurrence.api.domain.model.occurrence.commons.form.answer.Answer;
import br.com.occurrence.api.domain.model.occurrence.commons.form.question.TimeQuestion;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
public class TimeAnswerDto extends AnswerDto {

    private LocalTime time;

    public TimeAnswerDto(TimeQuestionDto question) {
        super(question);
    }

}

package br.com.occurrence.api.app.api.dto.occurrence.commons.form.answer;

import br.com.occurrence.api.app.api.dto.occurrence.commons.form.question.DateTimeQuestionDto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class DateTimeAnswerDto extends AnswerDto {

    private LocalDateTime dateTime;

    public DateTimeAnswerDto(DateTimeQuestionDto question) {
        super(question);
    }

}

package br.com.occurrence.api.app.api.dto.occurrence.commons.form.answer;

import br.com.occurrence.api.app.api.dto.occurrence.commons.form.question.DateQuestionDto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class DateAnswerDto extends AnswerDto {

    private LocalDate date;

    public DateAnswerDto(DateQuestionDto question) {
        super(question);
    }

}

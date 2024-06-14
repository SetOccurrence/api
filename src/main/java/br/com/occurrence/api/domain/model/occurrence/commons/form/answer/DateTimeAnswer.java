package br.com.occurrence.api.domain.model.occurrence.commons.form.answer;

import br.com.occurrence.api.domain.model.occurrence.commons.form.question.DateTimeQuestion;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class DateTimeAnswer extends Answer {

    private LocalDateTime dateTime;

    public DateTimeAnswer(DateTimeQuestion question) {
        super(question);
    }

}

package br.com.occurrence.api.domain.model.occurrence.commons.form.answer;

import br.com.occurrence.api.domain.model.occurrence.commons.form.question.DateQuestion;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class DateAnswer extends Answer {

    private LocalDate date;

    public DateAnswer(DateQuestion question) {
        super(question);
    }

}

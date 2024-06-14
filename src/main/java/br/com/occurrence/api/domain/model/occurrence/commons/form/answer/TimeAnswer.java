package br.com.occurrence.api.domain.model.occurrence.commons.form.answer;

import br.com.occurrence.api.domain.model.occurrence.commons.form.question.TimeQuestion;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
public class TimeAnswer extends Answer {

    private LocalTime time;

    public TimeAnswer(TimeQuestion question) {
        super(question);
    }

}

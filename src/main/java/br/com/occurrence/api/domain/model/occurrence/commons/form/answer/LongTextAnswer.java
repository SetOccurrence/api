package br.com.occurrence.api.domain.model.occurrence.commons.form.answer;

import br.com.occurrence.api.domain.model.occurrence.commons.form.question.LongTextQuestion;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LongTextAnswer extends Answer {

    private String answer;

    public LongTextAnswer(LongTextQuestion question) {
        super(question);
    }

}

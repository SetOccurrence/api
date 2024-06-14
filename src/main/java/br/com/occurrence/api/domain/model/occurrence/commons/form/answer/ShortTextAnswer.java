package br.com.occurrence.api.domain.model.occurrence.commons.form.answer;

import br.com.occurrence.api.domain.model.occurrence.commons.form.question.ShortTextQuestion;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShortTextAnswer extends Answer {

    private String answer;

    public ShortTextAnswer(ShortTextQuestion question) {
        super(question);
    }

}

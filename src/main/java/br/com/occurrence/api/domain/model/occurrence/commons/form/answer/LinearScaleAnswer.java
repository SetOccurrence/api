package br.com.occurrence.api.domain.model.occurrence.commons.form.answer;

import br.com.occurrence.api.domain.model.occurrence.commons.form.question.LinearScaleQuestion;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LinearScaleAnswer extends Answer {

    private int scaleIndex;

    public LinearScaleAnswer(LinearScaleQuestion question) {
        super(question);
    }

}

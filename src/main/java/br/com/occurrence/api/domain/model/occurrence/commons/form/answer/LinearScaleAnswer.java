package br.com.occurrence.api.domain.model.occurrence.commons.form.answer;

import br.com.occurrence.api.domain.model.occurrence.commons.form.question.LinearScaleQuestion;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LinearScaleAnswer extends Answer {

    private int scaleIndex;

    @Override
    public boolean isValid() {
        if (super.question.isOptional()) {
            return true;
        }
        LinearScaleQuestion question = (LinearScaleQuestion) super.question;
        return question.getMaxScale() >= scaleIndex && question.getMinScale() <= scaleIndex;
    }

}

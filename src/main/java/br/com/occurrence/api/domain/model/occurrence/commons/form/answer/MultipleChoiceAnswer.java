package br.com.occurrence.api.domain.model.occurrence.commons.form.answer;

import br.com.occurrence.api.domain.model.occurrence.commons.form.question.MultipleChoiceQuestion;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MultipleChoiceAnswer extends Answer {

    private boolean[] choices;

    public MultipleChoiceAnswer(MultipleChoiceQuestion question) {
        super(question);
    }

}

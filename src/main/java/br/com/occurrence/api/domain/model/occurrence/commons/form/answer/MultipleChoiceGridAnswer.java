package br.com.occurrence.api.domain.model.occurrence.commons.form.answer;

import br.com.occurrence.api.domain.model.occurrence.commons.form.question.MultipleCheckBoxGridQuestion;
import br.com.occurrence.api.domain.model.occurrence.commons.form.question.MultipleChoiceGridQuestion;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MultipleChoiceGridAnswer extends Answer {

    private boolean[][] choices;

    public MultipleChoiceGridAnswer(MultipleChoiceGridQuestion question) {
        super(question);
    }

}

package br.com.occurrence.api.domain.model.occurrence.commons.form.answer;

import br.com.occurrence.api.domain.model.occurrence.commons.form.question.MultipleCheckBoxGridQuestion;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MultipleCheckBoxGridAnswer extends Answer {

    private boolean[][] checkboxes;

    public MultipleCheckBoxGridAnswer(MultipleCheckBoxGridQuestion question) {
        super(question);
    }

}

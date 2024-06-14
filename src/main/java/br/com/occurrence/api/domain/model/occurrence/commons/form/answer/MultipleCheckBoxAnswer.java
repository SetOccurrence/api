package br.com.occurrence.api.domain.model.occurrence.commons.form.answer;

import br.com.occurrence.api.domain.model.occurrence.commons.form.question.MultipleCheckBoxQuestion;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MultipleCheckBoxAnswer extends Answer {

    private boolean[] checkboxes;

    public MultipleCheckBoxAnswer(MultipleCheckBoxQuestion question) {
        super(question);
    }

}

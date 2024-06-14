package br.com.occurrence.api.domain.model.occurrence.commons.form.answer;

import br.com.occurrence.api.domain.model.occurrence.commons.form.question.CheckBoxQuestion;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CheckBoxAnswer extends Answer {

    private boolean checked;

    public CheckBoxAnswer(CheckBoxQuestion question) {
        super(question);
    }

}

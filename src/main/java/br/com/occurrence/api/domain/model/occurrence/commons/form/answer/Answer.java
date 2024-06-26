package br.com.occurrence.api.domain.model.occurrence.commons.form.answer;

import br.com.occurrence.api.domain.model.occurrence.commons.form.question.Question;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Answer {

    protected Question question;
    public abstract boolean isValid();

}

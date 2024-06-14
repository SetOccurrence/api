package br.com.occurrence.api.domain.model.occurrence.commons.form.answer;

import br.com.occurrence.api.domain.model.occurrence.commons.form.question.Question;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class Answer {

    protected Question question;

}

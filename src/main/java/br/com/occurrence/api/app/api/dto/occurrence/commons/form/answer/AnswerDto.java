package br.com.occurrence.api.app.api.dto.occurrence.commons.form.answer;

import br.com.occurrence.api.app.api.dto.occurrence.commons.form.question.QuestionDto;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class AnswerDto {

    protected QuestionDto question;

}

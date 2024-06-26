package br.com.occurrence.api.app.api.dto.occurrence.commons.form.answer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MultipleChoiceAnswerDto extends AnswerDto {

    private boolean[] choices;

}

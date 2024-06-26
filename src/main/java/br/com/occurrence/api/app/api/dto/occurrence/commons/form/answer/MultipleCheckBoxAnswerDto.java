package br.com.occurrence.api.app.api.dto.occurrence.commons.form.answer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MultipleCheckBoxAnswerDto extends AnswerDto {

    private boolean[] checkboxes;

}

package br.com.occurrence.api.app.api.dto.occurrence.commons.form.answer;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShortTextAnswerDto extends AnswerDto {

    @NotBlank
    private String answer;

}

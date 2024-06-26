package br.com.occurrence.api.app.api.dto.occurrence.commons.form.answer;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class DateAnswerDto extends AnswerDto {

    @NotNull
    private LocalDate date;

}

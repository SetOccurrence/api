package br.com.occurrence.api.app.api.dto.occurrence.commons.form.answer;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
public class TimeAnswerDto extends AnswerDto {

    @NotNull
    private LocalTime time;

}

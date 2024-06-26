package br.com.occurrence.api.app.api.dto.occurrence.commons.form.answer;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class DateTimeAnswerDto extends AnswerDto {

    @NotNull
    private LocalDateTime dateTime;

}

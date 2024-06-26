package br.com.occurrence.api.domain.model.occurrence.commons.form.answer;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class DateTimeAnswer extends Answer {

    private LocalDateTime dateTime;

    @Override
    public boolean isValid() {
        if (super.question.isOptional()) {
            return true;
        }
        return dateTime != null;
    }

}

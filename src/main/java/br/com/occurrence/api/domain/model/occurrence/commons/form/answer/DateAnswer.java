package br.com.occurrence.api.domain.model.occurrence.commons.form.answer;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class DateAnswer extends Answer {

    private LocalDate date;

    @Override
    public boolean isValid() {
        if (super.question.isOptional()) {
            return true;
        }
        return date != null;
    }

}

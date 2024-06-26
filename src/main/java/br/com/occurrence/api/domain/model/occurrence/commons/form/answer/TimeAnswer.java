package br.com.occurrence.api.domain.model.occurrence.commons.form.answer;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
public class TimeAnswer extends Answer {

    private LocalTime time;

    @Override
    public boolean isValid() {
        if (super.question.isOptional()) {
            return true;
        }
        return time != null;
    }

}

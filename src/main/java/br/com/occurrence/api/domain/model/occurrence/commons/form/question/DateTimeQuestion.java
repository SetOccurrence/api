package br.com.occurrence.api.domain.model.occurrence.commons.form.question;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DateTimeQuestion extends Question {

    @Override
    public Type getType() {
        return Type.DATE_TIME;
    }

}

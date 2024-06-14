package br.com.occurrence.api.app.api.dto.occurrence.commons.form.question;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DateTimeQuestionDto extends QuestionDto {

    @Override
    public Type getType() {
        return Type.DATE_TIME;
    }

}

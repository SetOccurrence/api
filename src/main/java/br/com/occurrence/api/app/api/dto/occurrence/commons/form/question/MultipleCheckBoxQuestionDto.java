package br.com.occurrence.api.app.api.dto.occurrence.commons.form.question;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class MultipleCheckBoxQuestionDto extends QuestionDto {

    private Set<String> labels;

    @Override
    public Type getType() {
        return Type.MULTIPLE_CHECK_BOX;
    }

}

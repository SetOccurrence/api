package br.com.occurrence.api.app.api.dto.occurrence.commons.form.question;

import java.util.Set;

public class MultipleCheckBoxQuestionDto extends QuestionDto {

    private Set<String> labels;

    @Override
    public Type getType() {
        return Type.MULTIPLE_CHECK_BOX;
    }

}

package br.com.occurrence.api.app.api.dto.occurrence.commons.form.question;

import java.util.Set;

public class MultipleChoiceQuestionDto extends QuestionDto {

    private Set<String> choices;

    @Override
    public Type getType() {
        return Type.MULTIPLE_CHOICE;
    }

}


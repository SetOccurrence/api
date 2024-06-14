package br.com.occurrence.api.app.api.dto.occurrence.commons.form.question;

import java.util.List;

public class MultipleChoiceGridQuestionDto extends QuestionDto {

    private List<String> rowsLabel;
    private List<String> columnsLabel;

    @Override
    public Type getType() {
        return Type.MULTIPLE_CHOICE_GRID;
    }

}

package br.com.occurrence.api.app.api.dto.occurrence.commons.form.question;

public class CheckBoxQuestionDto extends QuestionDto {

    private String label;

    @Override
    public Type getType() {
        return Type.CHECK_BOX;
    }

}

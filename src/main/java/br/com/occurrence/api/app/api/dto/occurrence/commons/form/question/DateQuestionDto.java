package br.com.occurrence.api.app.api.dto.occurrence.commons.form.question;

public class DateQuestionDto extends QuestionDto {

    @Override
    public Type getType() {
        return Type.DATE;
    }

}

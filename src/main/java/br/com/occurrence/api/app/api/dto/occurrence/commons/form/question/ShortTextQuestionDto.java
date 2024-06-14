package br.com.occurrence.api.app.api.dto.occurrence.commons.form.question;

public class ShortTextQuestionDto extends QuestionDto {

    @Override
    public Type getType() {
        return Type.SHORT_TEXT;
    }

}

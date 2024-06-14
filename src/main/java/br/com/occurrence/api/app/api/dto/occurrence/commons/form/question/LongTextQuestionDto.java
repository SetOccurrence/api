package br.com.occurrence.api.app.api.dto.occurrence.commons.form.question;

public class LongTextQuestionDto extends QuestionDto {

    @Override
    public Type getType() {
        return Type.LONG_TEXT;
    }

}

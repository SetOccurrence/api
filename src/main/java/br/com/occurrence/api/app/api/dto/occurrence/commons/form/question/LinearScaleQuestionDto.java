package br.com.occurrence.api.app.api.dto.occurrence.commons.form.question;

public class LinearScaleQuestionDto extends QuestionDto {

    private int startsWith;
    private int endsWith;
    private String startLabel;
    private String endLabel;

    private int range() {
        return (endsWith - startsWith) + 1;
    }

    @Override
    public Type getType() {
        return Type.LINEAR_SCALE;
    }

}

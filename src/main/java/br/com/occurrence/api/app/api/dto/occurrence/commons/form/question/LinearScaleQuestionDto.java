package br.com.occurrence.api.app.api.dto.occurrence.commons.form.question;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LinearScaleQuestionDto extends QuestionDto {

    private int minScale;
    private int maxScale;
    private String minScaleLabel;
    private String maxScaleLabel;

    private int range() {
        return (maxScale - minScale) + 1;
    }

    @Override
    public Type getType() {
        return Type.LINEAR_SCALE;
    }

}

package br.com.occurrence.api.domain.model.occurrence.commons.form.question;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LinearScaleQuestion extends Question {

    private int minScale;
    private int maxScale;
    private String minScaleLabel;
    private String maxScaleLabel;

    @Override
    public Type getType() {
        return Type.LINEAR_SCALE;
    }

}

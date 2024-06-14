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

    private int scaleSize;
    private String startLabel;
    private String endLabel;

    @Override
    public Type getType() {
        return Type.LINEAR_SCALE;
    }

}

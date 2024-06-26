package br.com.occurrence.api.domain.model.occurrence.commons.form.answer;

import io.micrometer.common.util.StringUtils;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShortTextAnswer extends Answer {

    private String answer;

    @Override
    public boolean isValid() {
        if (super.question.isOptional()) {
            return true;
        }
        return !StringUtils.isBlank(answer);
    }

}

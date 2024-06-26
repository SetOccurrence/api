package br.com.occurrence.api.domain.model.occurrence.commons.form.answer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MultipleChoiceGridAnswer extends Answer {

    private boolean[][] choices;

    @Override
    public boolean isValid() {
        return true;
    }

}

package br.com.occurrence.api.domain.model.occurrence.commons.form.answer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MultipleCheckBoxAnswer extends Answer {

    private boolean[] checkboxes;

    @Override
    public boolean isValid() {
        return true;
    }

}

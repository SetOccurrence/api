package br.com.occurrence.api.domain.model.occurrence.commons.form.answer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CheckBoxAnswer extends Answer {

    private boolean checked;

    @Override
    public boolean isValid() {
        return true;
    }

}

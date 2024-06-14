package br.com.occurrence.api.domain.model.occurrence.commons.form.question;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MultipleCheckBoxQuestion extends Question {

    private Set<String> labels;

    @Override
    public Type getType() {
        return Type.MULTIPLE_CHECK_BOX;
    }

}

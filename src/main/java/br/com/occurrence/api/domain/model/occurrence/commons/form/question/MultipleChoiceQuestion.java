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
public class MultipleChoiceQuestion extends Question {

    private Set<String> options;

    @Override
    public Type getType() {
        return Type.MULTIPLE_CHOICE;
    }

}


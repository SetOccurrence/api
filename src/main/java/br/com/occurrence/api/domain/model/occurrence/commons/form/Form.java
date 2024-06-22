package br.com.occurrence.api.domain.model.occurrence.commons.form;

import br.com.occurrence.api.domain.model.occurrence.commons.form.question.Question;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashSet;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Form {

    private LinkedHashSet<Question> questions;

}

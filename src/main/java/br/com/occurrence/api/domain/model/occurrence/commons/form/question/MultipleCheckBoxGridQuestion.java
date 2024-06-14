package br.com.occurrence.api.domain.model.occurrence.commons.form.question;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MultipleCheckBoxGridQuestion extends Question {

    private List<String> rowsLabel;
    private List<String> columnsLabel;

    @Override
    public Type getType() {
        return Type.MULTIPLE_CHECK_BOX_GRID;
    }

}

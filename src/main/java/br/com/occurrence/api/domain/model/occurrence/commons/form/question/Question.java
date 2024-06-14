package br.com.occurrence.api.domain.model.occurrence.commons.form.question;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Question {

    protected String name;
    protected String description;
    protected boolean optional;

    public abstract Type getType();

    public enum Type {
        SHORT_TEXT,
        LONG_TEXT,
        MULTIPLE_CHOICE,
        CHECK_BOX,
        MULTIPLE_CHECK_BOX,
        LINEAR_SCALE,
        MULTIPLE_CHOICE_GRID,
        MULTIPLE_CHECK_BOX_GRID,
        DATE,
        DATE_TIME,
        TIME,
    }

}

package br.com.occurrence.api.app.api.dto.occurrence.commons.form.question;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class QuestionDto {

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

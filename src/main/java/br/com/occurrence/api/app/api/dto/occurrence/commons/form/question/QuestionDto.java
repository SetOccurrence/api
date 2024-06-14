package br.com.occurrence.api.app.api.dto.occurrence.commons.form.question;

public abstract class QuestionDto {

    private String name;
    private String description;
    private boolean optional;

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

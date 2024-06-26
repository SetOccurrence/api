package br.com.occurrence.api.domain.mapper;

import br.com.occurrence.api.app.api.dto.occurrence.commons.form.question.*;
import br.com.occurrence.api.domain.model.occurrence.commons.form.question.*;
import lombok.experimental.UtilityClass;

@UtilityClass
public class QuestionMapper {

    public static QuestionDto toQuestionDto(Question question) {
        if (question == null) {
            return null;
        }
        Question.Type type = question.getType();
        return switch (type) {
            case SHORT_TEXT -> toShortTextQuestionDto((ShortTextQuestion) question);
            case LONG_TEXT -> toLongTextQuestionDto((LongTextQuestion) question);
            case MULTIPLE_CHOICE -> toMultipleChoiceQuestionDto((MultipleChoiceQuestion) question);
            case CHECK_BOX -> toCheckBoxQuestionDto((CheckBoxQuestion) question);
            case MULTIPLE_CHECK_BOX -> toMultipleCheckBoxQuestionDto((MultipleCheckBoxQuestion) question);
            case LINEAR_SCALE -> toLinearScaleQuestionDto((LinearScaleQuestion) question);
            case MULTIPLE_CHOICE_GRID -> toMultipleChoiceGridQuestionDto((MultipleChoiceGridQuestion) question);
            case MULTIPLE_CHECK_BOX_GRID -> toMultipleCheckBoxGridQuestionDto((MultipleCheckBoxGridQuestion) question);
            case DATE -> toDateQuestionDto((DateQuestion) question);
            case DATE_TIME -> toDateTimeQuestionDto((DateTimeQuestion) question);
            case TIME -> toTimeQuestionDto((TimeQuestion) question);
        };
    }

    public static Question toQuestion(QuestionDto questionDto) {
        if (questionDto == null) {
            return null;
        }
        QuestionDto.Type type = questionDto.getType();
        return switch (type) {
            case SHORT_TEXT -> toShortTextQuestion((ShortTextQuestionDto) questionDto);
            case LONG_TEXT -> toLongTextQuestion((LongTextQuestionDto) questionDto);
            case MULTIPLE_CHOICE -> toMultipleChoiceQuestion((MultipleChoiceQuestionDto) questionDto);
            case CHECK_BOX -> toCheckBoxQuestion((CheckBoxQuestionDto) questionDto);
            case MULTIPLE_CHECK_BOX -> toMultipleCheckBoxQuestion((MultipleCheckBoxQuestionDto) questionDto);
            case LINEAR_SCALE -> toLinearScaleQuestion((LinearScaleQuestionDto) questionDto);
            case MULTIPLE_CHOICE_GRID -> toMultipleChoiceGridQuestion((MultipleChoiceGridQuestionDto) questionDto);
            case MULTIPLE_CHECK_BOX_GRID -> toMultipleCheckBoxGridQuestion((MultipleCheckBoxGridQuestionDto) questionDto);
            case DATE -> toDateQuestion((DateQuestionDto) questionDto);
            case DATE_TIME -> toDateTimeQuestion((DateTimeQuestionDto) questionDto);
            case TIME -> toTimeQuestion((TimeQuestionDto) questionDto);
        };
    }

    private static ShortTextQuestionDto toShortTextQuestionDto(ShortTextQuestion question) {
        ShortTextQuestionDto dto = new ShortTextQuestionDto();
        dto.setName(question.getName());
        dto.setDescription(question.getDescription());
        dto.setOptional(question.isOptional());
        return dto;
    }

    private static LongTextQuestionDto toLongTextQuestionDto(LongTextQuestion question) {
        LongTextQuestionDto dto = new LongTextQuestionDto();
        dto.setName(question.getName());
        dto.setDescription(question.getDescription());
        dto.setOptional(question.isOptional());
        return dto;
    }

    private static MultipleChoiceQuestionDto toMultipleChoiceQuestionDto(MultipleChoiceQuestion question) {
        MultipleChoiceQuestionDto dto = new MultipleChoiceQuestionDto();
        dto.setName(question.getName());
        dto.setDescription(question.getDescription());
        dto.setOptional(question.isOptional());
        dto.setOptions(question.getOptions());
        return dto;
    }

    private static CheckBoxQuestionDto toCheckBoxQuestionDto(CheckBoxQuestion question) {
        CheckBoxQuestionDto dto = new CheckBoxQuestionDto();
        dto.setName(question.getName());
        dto.setDescription(question.getDescription());
        dto.setOptional(question.isOptional());
        dto.setLabel(question.getLabel());
        return dto;
    }

    private static MultipleCheckBoxQuestionDto toMultipleCheckBoxQuestionDto(MultipleCheckBoxQuestion question) {
        MultipleCheckBoxQuestionDto dto = new MultipleCheckBoxQuestionDto();
        dto.setName(question.getName());
        dto.setDescription(question.getDescription());
        dto.setOptional(question.isOptional());
        dto.setLabels(question.getLabels());
        return dto;
    }

    private static LinearScaleQuestionDto toLinearScaleQuestionDto(LinearScaleQuestion question) {
        LinearScaleQuestionDto dto = new LinearScaleQuestionDto();
        dto.setName(question.getName());
        dto.setDescription(question.getDescription());
        dto.setOptional(question.isOptional());
        dto.setMinScale(question.getMinScale());
        dto.setMaxScale(question.getMaxScale());
        dto.setMinScaleLabel(question.getMinScaleLabel());
        dto.setMaxScaleLabel(question.getMaxScaleLabel());
        return dto;
    }

    private static MultipleChoiceGridQuestionDto toMultipleChoiceGridQuestionDto(MultipleChoiceGridQuestion question) {
        MultipleChoiceGridQuestionDto dto = new MultipleChoiceGridQuestionDto();
        dto.setName(question.getName());
        dto.setDescription(question.getDescription());
        dto.setOptional(question.isOptional());
        dto.setRowsLabel(question.getRowsLabel());
        dto.setColumnsLabel(question.getColumnsLabel());
        return dto;
    }

    private static MultipleCheckBoxGridQuestionDto toMultipleCheckBoxGridQuestionDto(MultipleCheckBoxGridQuestion question) {
        MultipleCheckBoxGridQuestionDto dto = new MultipleCheckBoxGridQuestionDto();
        dto.setName(question.getName());
        dto.setDescription(question.getDescription());
        dto.setOptional(question.isOptional());
        dto.setRowsLabel(question.getRowsLabel());
        dto.setColumnsLabel(question.getColumnsLabel());
        return dto;
    }

    private static DateQuestionDto toDateQuestionDto(DateQuestion question) {
        DateQuestionDto dto = new DateQuestionDto();
        dto.setName(question.getName());
        dto.setDescription(question.getDescription());
        dto.setOptional(question.isOptional());
        return dto;
    }

    private static DateTimeQuestionDto toDateTimeQuestionDto(DateTimeQuestion question) {
        DateTimeQuestionDto dto = new DateTimeQuestionDto();
        dto.setName(question.getName());
        dto.setDescription(question.getDescription());
        dto.setOptional(question.isOptional());
        return dto;
    }

    private static TimeQuestionDto toTimeQuestionDto(TimeQuestion question) {
        TimeQuestionDto dto = new TimeQuestionDto();
        dto.setName(question.getName());
        dto.setDescription(question.getDescription());
        dto.setOptional(question.isOptional());
        return dto;
    }

    private static ShortTextQuestion toShortTextQuestion(ShortTextQuestionDto dto) {
        ShortTextQuestion question = new ShortTextQuestion();
        question.setName(dto.getName());
        question.setDescription(dto.getDescription());
        question.setOptional(dto.isOptional());
        return question;
    }

    private static LongTextQuestion toLongTextQuestion(LongTextQuestionDto dto) {
        LongTextQuestion question = new LongTextQuestion();
        question.setName(dto.getName());
        question.setDescription(dto.getDescription());
        question.setOptional(dto.isOptional());
        return question;
    }

    private static MultipleChoiceQuestion toMultipleChoiceQuestion(MultipleChoiceQuestionDto dto) {
        MultipleChoiceQuestion question = new MultipleChoiceQuestion();
        question.setName(dto.getName());
        question.setDescription(dto.getDescription());
        question.setOptional(dto.isOptional());
        question.setOptions(dto.getOptions());
        return question;
    }

    private static CheckBoxQuestion toCheckBoxQuestion(CheckBoxQuestionDto dto) {
        CheckBoxQuestion question = new CheckBoxQuestion();
        question.setName(dto.getName());
        question.setDescription(dto.getDescription());
        question.setOptional(dto.isOptional());
        question.setLabel(dto.getLabel());
        return question;
    }

    private static MultipleCheckBoxQuestion toMultipleCheckBoxQuestion(MultipleCheckBoxQuestionDto dto) {
        MultipleCheckBoxQuestion question = new MultipleCheckBoxQuestion();
        question.setName(dto.getName());
        question.setDescription(dto.getDescription());
        question.setOptional(dto.isOptional());
        question.setLabels(dto.getLabels());
        return question;
    }

    private static LinearScaleQuestion toLinearScaleQuestion(LinearScaleQuestionDto dto) {
        LinearScaleQuestion question = new LinearScaleQuestion();
        question.setName(dto.getName());
        question.setDescription(dto.getDescription());
        question.setOptional(dto.isOptional());
        question.setMinScale(dto.getMinScale());
        question.setMaxScale(dto.getMaxScale());
        question.setMinScaleLabel(dto.getMinScaleLabel());
        question.setMaxScaleLabel(dto.getMaxScaleLabel());
        return question;
    }

    private static MultipleChoiceGridQuestion toMultipleChoiceGridQuestion(MultipleChoiceGridQuestionDto dto) {
        MultipleChoiceGridQuestion question = new MultipleChoiceGridQuestion();
        question.setName(dto.getName());
        question.setDescription(dto.getDescription());
        question.setOptional(dto.isOptional());
        question.setRowsLabel(dto.getRowsLabel());
        question.setColumnsLabel(dto.getColumnsLabel());
        return question;
    }

    private static MultipleCheckBoxGridQuestion toMultipleCheckBoxGridQuestion(MultipleCheckBoxGridQuestionDto dto) {
        MultipleCheckBoxGridQuestion question = new MultipleCheckBoxGridQuestion();
        question.setName(dto.getName());
        question.setDescription(dto.getDescription());
        question.setOptional(dto.isOptional());
        question.setRowsLabel(dto.getRowsLabel());
        question.setColumnsLabel(dto.getColumnsLabel());
        return question;
    }

    private static DateQuestion toDateQuestion(DateQuestionDto dto) {
        DateQuestion question = new DateQuestion();
        question.setName(dto.getName());
        question.setDescription(dto.getDescription());
        question.setOptional(dto.isOptional());
        return question;
    }

    private static DateTimeQuestion toDateTimeQuestion(DateTimeQuestionDto dto) {
        DateTimeQuestion question = new DateTimeQuestion();
        question.setName(dto.getName());
        question.setDescription(dto.getDescription());
        question.setOptional(dto.isOptional());
        return question;
    }

    private static TimeQuestion toTimeQuestion(TimeQuestionDto dto) {
        TimeQuestion question = new TimeQuestion();
        question.setName(dto.getName());
        question.setDescription(dto.getDescription());
        question.setOptional(dto.isOptional());
        return question;
    }

}

package br.com.occurrence.api.domain.mapper;

import br.com.occurrence.api.app.api.dto.occurrence.commons.form.answer.*;
import br.com.occurrence.api.domain.model.occurrence.commons.form.answer.*;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class AnswerMapper {

    public static List<AnswerDto> toAnswerDto(List<Answer> answers) {
        return answers.stream()
                .map(AnswerMapper::toAnswerDto)
                .toList();
    }

    public static List<Answer> toAnswer(List<AnswerDto> answersDto) {
        return answersDto.stream()
                .map(AnswerMapper::toAnswer)
                .toList();
    }

    public static AnswerDto toAnswerDto(Answer answer) {
        return switch (answer.getQuestion().getType()) {
            case SHORT_TEXT -> toShortTextAnswerDto((ShortTextAnswer) answer);
            case LONG_TEXT -> toLongTextAnswerDto((LongTextAnswer) answer);
            case MULTIPLE_CHOICE -> toMultipleChoiceAnswerDto((MultipleChoiceAnswer) answer);
            case CHECK_BOX -> toCheckBoxAnswerDto((CheckBoxAnswer) answer);
            case MULTIPLE_CHECK_BOX -> toMultipleCheckBoxAnswerDto((MultipleCheckBoxAnswer) answer);
            case LINEAR_SCALE -> toLinearScaleAnswerDto((LinearScaleAnswer) answer);
            case MULTIPLE_CHOICE_GRID -> toMultipleChoiceGridAnswerDto((MultipleChoiceGridAnswer) answer);
            case MULTIPLE_CHECK_BOX_GRID -> toMultipleCheckBoxGridAnswerDto((MultipleCheckBoxGridAnswer) answer);
            case DATE -> toDateAnswerDto((DateAnswer) answer);
            case DATE_TIME -> toDateTimeAnswerDto((DateTimeAnswer) answer);
            case TIME -> toTimeAnswerDto((TimeAnswer) answer);
        };
    }

    public static Answer toAnswer(AnswerDto answerDto) {
        return switch (answerDto.getQuestion().getType()) {
            case SHORT_TEXT -> toShortTextAnswer((ShortTextAnswerDto) answerDto);
            case LONG_TEXT -> toLongTextAnswer((LongTextAnswerDto) answerDto);
            case MULTIPLE_CHOICE -> toMultipleChoiceAnswer((MultipleChoiceAnswerDto) answerDto);
            case CHECK_BOX -> toCheckBoxAnswer((CheckBoxAnswerDto) answerDto);
            case MULTIPLE_CHECK_BOX -> toMultipleCheckBoxAnswer((MultipleCheckBoxAnswerDto) answerDto);
            case LINEAR_SCALE -> toLinearScaleAnswer((LinearScaleAnswerDto) answerDto);
            case MULTIPLE_CHOICE_GRID -> toMultipleChoiceGridAnswer((MultipleChoiceGridAnswerDto) answerDto);
            case MULTIPLE_CHECK_BOX_GRID -> toMultipleCheckBoxGridAnswer((MultipleCheckBoxGridAnswerDto) answerDto);
            case DATE -> toDateAnswer((DateAnswerDto) answerDto);
            case DATE_TIME -> toDateTimeAnswer((DateTimeAnswerDto) answerDto);
            case TIME -> toTimeAnswer((TimeAnswerDto) answerDto);
        };
    }

    private static ShortTextAnswerDto toShortTextAnswerDto(ShortTextAnswer shortTextAnswer) {
        ShortTextAnswerDto dto = new ShortTextAnswerDto();
        dto.setQuestion(QuestionMapper.toQuestionDto(shortTextAnswer.getQuestion()));
        dto.setAnswer(shortTextAnswer.getAnswer());
        return dto;
    }

    private static ShortTextAnswer toShortTextAnswer(ShortTextAnswerDto dto) {
        ShortTextAnswer shortTextAnswer = new ShortTextAnswer();
        shortTextAnswer.setQuestion(QuestionMapper.toQuestion(dto.getQuestion()));
        shortTextAnswer.setAnswer(dto.getAnswer());
        return shortTextAnswer;
    }

    private static LongTextAnswerDto toLongTextAnswerDto(LongTextAnswer longTextAnswer) {
        LongTextAnswerDto dto = new LongTextAnswerDto();
        dto.setQuestion(QuestionMapper.toQuestionDto(longTextAnswer.getQuestion()));
        dto.setAnswer(longTextAnswer.getAnswer());
        return dto;
    }

    private static LongTextAnswer toLongTextAnswer(LongTextAnswerDto dto) {
        LongTextAnswer longTextAnswer = new LongTextAnswer();
        longTextAnswer.setQuestion(QuestionMapper.toQuestion(dto.getQuestion()));
        longTextAnswer.setAnswer(dto.getAnswer());
        return longTextAnswer;
    }

    private static MultipleChoiceAnswerDto toMultipleChoiceAnswerDto(MultipleChoiceAnswer multipleChoiceAnswer) {
        MultipleChoiceAnswerDto dto = new MultipleChoiceAnswerDto();
        dto.setQuestion(QuestionMapper.toQuestionDto(multipleChoiceAnswer.getQuestion()));
        dto.setChoices(multipleChoiceAnswer.getChoices());
        return dto;
    }

    private static MultipleChoiceAnswer toMultipleChoiceAnswer(MultipleChoiceAnswerDto dto) {
        MultipleChoiceAnswer multipleChoiceAnswer = new MultipleChoiceAnswer();
        multipleChoiceAnswer.setQuestion(QuestionMapper.toQuestion(dto.getQuestion()));
        multipleChoiceAnswer.setChoices(dto.getChoices());
        return multipleChoiceAnswer;
    }

    private static CheckBoxAnswerDto toCheckBoxAnswerDto(CheckBoxAnswer checkBoxAnswer) {
        CheckBoxAnswerDto dto = new CheckBoxAnswerDto();
        dto.setQuestion(QuestionMapper.toQuestionDto(checkBoxAnswer.getQuestion()));
        dto.setChecked(checkBoxAnswer.isChecked());
        return dto;
    }

    private static CheckBoxAnswer toCheckBoxAnswer(CheckBoxAnswerDto dto) {
        CheckBoxAnswer checkBoxAnswer = new CheckBoxAnswer();
        checkBoxAnswer.setQuestion(QuestionMapper.toQuestion(dto.getQuestion()));
        checkBoxAnswer.setChecked(dto.isChecked());
        return checkBoxAnswer;
    }

    private static MultipleCheckBoxAnswerDto toMultipleCheckBoxAnswerDto(MultipleCheckBoxAnswer multipleCheckBoxAnswer) {
        MultipleCheckBoxAnswerDto dto = new MultipleCheckBoxAnswerDto();
        dto.setQuestion(QuestionMapper.toQuestionDto(multipleCheckBoxAnswer.getQuestion()));
        dto.setCheckboxes(multipleCheckBoxAnswer.getCheckboxes());
        return dto;
    }

    private static MultipleCheckBoxAnswer toMultipleCheckBoxAnswer(MultipleCheckBoxAnswerDto dto) {
        MultipleCheckBoxAnswer multipleCheckBoxAnswer = new MultipleCheckBoxAnswer();
        multipleCheckBoxAnswer.setQuestion(QuestionMapper.toQuestion(dto.getQuestion()));
        multipleCheckBoxAnswer.setCheckboxes(dto.getCheckboxes());
        return multipleCheckBoxAnswer;
    }

    private static LinearScaleAnswerDto toLinearScaleAnswerDto(LinearScaleAnswer linearScaleAnswer) {
        LinearScaleAnswerDto dto = new LinearScaleAnswerDto();
        dto.setQuestion(QuestionMapper.toQuestionDto(linearScaleAnswer.getQuestion()));
        dto.setScaleIndex(linearScaleAnswer.getScaleIndex());
        return dto;
    }

    private static LinearScaleAnswer toLinearScaleAnswer(LinearScaleAnswerDto dto) {
        LinearScaleAnswer linearScaleAnswer = new LinearScaleAnswer();
        linearScaleAnswer.setQuestion(QuestionMapper.toQuestion(dto.getQuestion()));
        linearScaleAnswer.setScaleIndex(dto.getScaleIndex());
        return linearScaleAnswer;
    }

    private static MultipleChoiceGridAnswerDto toMultipleChoiceGridAnswerDto(MultipleChoiceGridAnswer multipleChoiceGridAnswer) {
        MultipleChoiceGridAnswerDto dto = new MultipleChoiceGridAnswerDto();
        dto.setQuestion(QuestionMapper.toQuestionDto(multipleChoiceGridAnswer.getQuestion()));
        dto.setChoices(multipleChoiceGridAnswer.getChoices());
        return dto;
    }

    private static MultipleChoiceGridAnswer toMultipleChoiceGridAnswer(MultipleChoiceGridAnswerDto dto) {
        MultipleChoiceGridAnswer multipleChoiceGridAnswer = new MultipleChoiceGridAnswer();
        multipleChoiceGridAnswer.setQuestion(QuestionMapper.toQuestion(dto.getQuestion()));
        multipleChoiceGridAnswer.setChoices(dto.getChoices());
        return multipleChoiceGridAnswer;
    }

    private static MultipleCheckBoxGridAnswerDto toMultipleCheckBoxGridAnswerDto(MultipleCheckBoxGridAnswer multipleCheckBoxGridAnswer) {
        MultipleCheckBoxGridAnswerDto dto = new MultipleCheckBoxGridAnswerDto();
        dto.setQuestion(QuestionMapper.toQuestionDto(multipleCheckBoxGridAnswer.getQuestion()));
        dto.setCheckboxes(multipleCheckBoxGridAnswer.getCheckboxes());
        return dto;
    }

    private static MultipleCheckBoxGridAnswer toMultipleCheckBoxGridAnswer(MultipleCheckBoxGridAnswerDto dto) {
        MultipleCheckBoxGridAnswer multipleCheckBoxGridAnswer = new MultipleCheckBoxGridAnswer();
        multipleCheckBoxGridAnswer.setQuestion(QuestionMapper.toQuestion(dto.getQuestion()));
        multipleCheckBoxGridAnswer.setCheckboxes(dto.getCheckboxes());
        return multipleCheckBoxGridAnswer;
    }

    private static DateAnswerDto toDateAnswerDto(DateAnswer dateAnswer) {
        DateAnswerDto dto = new DateAnswerDto();
        dto.setQuestion(QuestionMapper.toQuestionDto(dateAnswer.getQuestion()));
        dto.setDate(dateAnswer.getDate());
        return dto;
    }

    private static DateAnswer toDateAnswer(DateAnswerDto dto) {
        DateAnswer dateAnswer = new DateAnswer();
        dateAnswer.setQuestion(QuestionMapper.toQuestion(dto.getQuestion()));
        dateAnswer.setDate(dto.getDate());
        return dateAnswer;
    }

    private static DateTimeAnswerDto toDateTimeAnswerDto(DateTimeAnswer dateTimeAnswer) {
        DateTimeAnswerDto dto = new DateTimeAnswerDto();
        dto.setQuestion(QuestionMapper.toQuestionDto(dateTimeAnswer.getQuestion()));
        dto.setDateTime(dateTimeAnswer.getDateTime());
        return dto;
    }

    private static DateTimeAnswer toDateTimeAnswer(DateTimeAnswerDto dto) {
        DateTimeAnswer dateTimeAnswer = new DateTimeAnswer();
        dateTimeAnswer.setQuestion(QuestionMapper.toQuestion(dto.getQuestion()));
        dateTimeAnswer.setDateTime(dto.getDateTime());
        return dateTimeAnswer;
    }

    private static TimeAnswerDto toTimeAnswerDto(TimeAnswer timeAnswer) {
        TimeAnswerDto dto = new TimeAnswerDto();
        dto.setQuestion(QuestionMapper.toQuestionDto(timeAnswer.getQuestion()));
        dto.setTime(timeAnswer.getTime());
        return dto;
    }

    private static TimeAnswer toTimeAnswer(TimeAnswerDto dto) {
        TimeAnswer timeAnswer = new TimeAnswer();
        timeAnswer.setQuestion(QuestionMapper.toQuestion(dto.getQuestion()));
        timeAnswer.setTime(dto.getTime());
        return timeAnswer;
    }

}

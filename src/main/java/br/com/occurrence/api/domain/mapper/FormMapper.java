package br.com.occurrence.api.domain.mapper;

import br.com.occurrence.api.app.api.dto.occurrence.commons.form.FormDto;
import br.com.occurrence.api.app.api.dto.occurrence.commons.form.question.QuestionDto;
import br.com.occurrence.api.domain.model.occurrence.commons.form.Form;
import br.com.occurrence.api.domain.model.occurrence.commons.form.question.Question;
import lombok.experimental.UtilityClass;

import java.util.LinkedHashSet;
import java.util.stream.Collectors;

@UtilityClass
public class FormMapper {

    public static FormDto toFormDto(Form form) {
        if (form == null) {
            return null;
        }
        LinkedHashSet<QuestionDto> questions = form.getQuestions()
                .stream()
                .map(QuestionMapper::toQuestionDto)
                .collect(Collectors.toCollection(LinkedHashSet::new));
        return new FormDto(questions);
    }

    public static Form toForm(FormDto formDto) {
        if (formDto == null) {
            return null;
        }
        LinkedHashSet<Question> questions = formDto.questions()
                .stream()
                .map(QuestionMapper::toQuestion)
                .collect(Collectors.toCollection(LinkedHashSet::new));
        return new Form(questions);
    }

}

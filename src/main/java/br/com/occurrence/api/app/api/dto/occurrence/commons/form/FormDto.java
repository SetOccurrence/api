package br.com.occurrence.api.app.api.dto.occurrence.commons.form;

import br.com.occurrence.api.app.api.dto.occurrence.commons.form.question.QuestionDto;

import java.util.LinkedHashSet;

public record FormDto(LinkedHashSet<QuestionDto> questions) {
}

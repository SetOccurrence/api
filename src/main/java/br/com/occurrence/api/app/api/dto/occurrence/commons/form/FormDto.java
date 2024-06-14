package br.com.occurrence.api.app.api.dto.occurrence.commons.form;

import br.com.occurrence.api.app.api.dto.occurrence.commons.form.question.QuestionDto;

import java.util.Set;

public record FormDto(String name, String description, Set<QuestionDto> questions) {
}

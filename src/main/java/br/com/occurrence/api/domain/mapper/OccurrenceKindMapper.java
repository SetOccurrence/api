package br.com.occurrence.api.domain.mapper;

import br.com.occurrence.api.app.api.dto.occurrence.OccurrenceKindDto;
import br.com.occurrence.api.app.api.dto.occurrence.OccurrenceKindFormDto;
import br.com.occurrence.api.app.api.dto.occurrence.commons.flow.FlowMapDto;
import br.com.occurrence.api.app.api.dto.occurrence.commons.form.FormDto;
import br.com.occurrence.api.app.api.dto.occurrence.commons.form.question.*;
import br.com.occurrence.api.app.api.dto.occurrence.commons.step.AuthorizationStepDto;
import br.com.occurrence.api.app.api.dto.occurrence.commons.step.FormStepDto;
import br.com.occurrence.api.app.api.dto.occurrence.commons.step.StepDto;
import br.com.occurrence.api.app.api.dto.organization.commons.EntityDto;
import br.com.occurrence.api.domain.model.occurrence.OccurrenceKind;
import br.com.occurrence.api.domain.model.occurrence.commons.flow.FlowMap;
import br.com.occurrence.api.domain.model.occurrence.commons.form.Form;
import br.com.occurrence.api.domain.model.occurrence.commons.form.question.*;
import br.com.occurrence.api.domain.model.occurrence.commons.step.AuthorizationStep;
import br.com.occurrence.api.domain.model.occurrence.commons.step.FormStep;
import br.com.occurrence.api.domain.model.occurrence.commons.step.Step;
import br.com.occurrence.api.domain.model.organization.Entity;
import br.com.occurrence.api.domain.service.*;
import br.com.occurrence.api.domain.util.PropertiesHelper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class OccurrenceKindMapper {

    private final UnitService unitService;
    private final DepartmentService departmentService;
    private final SectorService sectorService;
    private final TeamService teamService;
    private final UserReadService userReadService;

    public void updateOccurrenceKindFromDto(OccurrenceKind occurrenceKind, OccurrenceKindFormDto form) {
        PropertiesHelper.copyNonNullProperties(toOccurrenceKind(form), occurrenceKind);
    }

    public OccurrenceKind toOccurrenceKind(OccurrenceKindFormDto form) {
        OccurrenceKind occurrenceKind = new OccurrenceKind();
        occurrenceKind.setName(form.name());
        occurrenceKind.setPrefix(form.prefix());
        occurrenceKind.setDescription(form.description());
        occurrenceKind.setCategory(form.category());
        occurrenceKind.setFlowMap(toFlowMap(form.flowMap()));
        return occurrenceKind;
    }

    public OccurrenceKindDto toOccurrenceKindDto(OccurrenceKind occurrenceKind) {
        return new OccurrenceKindDto(
            occurrenceKind.getId(),
            occurrenceKind.getName(),
            occurrenceKind.getPrefix(),
            occurrenceKind.getDescription(),
            occurrenceKind.getCategory(),
            OccurrenceKindDto.Status.valueOf(occurrenceKind.getStatus().name()),
            toFlowMapDto(occurrenceKind.getFlowMap())
        );
    }

    public FlowMapDto toFlowMapDto(FlowMap flowMap) {
        LinkedList<StepDto> steps = flowMap.getSteps()
                .stream()
                .map(this::toStepDto)
                .collect(Collectors.toCollection(LinkedList::new));
        return new FlowMapDto(steps);
    }

    public FlowMap toFlowMap(FlowMapDto flowMap) {
        if (flowMap == null) {
            return null;
        }
        LinkedList<Step> steps = flowMap.steps()
                .stream()
                .map(this::toStep)
                .collect(Collectors.toCollection(LinkedList::new));
        return new FlowMap(steps);
    }

    public StepDto toStepDto(Step step) {
        if (step == null) {
            return null;
        }
        Step.Type type = step.getType();
        return switch (type) {
            case AUTHORIZATION -> toAuthorizationStepDto((AuthorizationStep) step);
            case FORM -> toFormStepDto((FormStep) step);
        };
    }

    public Step toStep(StepDto stepDto) {
        if (stepDto == null) {
            return null;
        }
        StepDto.Type type = stepDto.getType();
        return switch (type) {
            case AUTHORIZATION -> toAuthorizationStep((AuthorizationStepDto) stepDto);
            case FORM -> toFormStep((FormStepDto) stepDto);
        };
    }

    public AuthorizationStepDto toAuthorizationStepDto(AuthorizationStep authorizationStep) {
        if (authorizationStep == null) {
            return null;
        }
        AuthorizationStepDto authorizationStepDto = new AuthorizationStepDto();
        authorizationStepDto.setName(authorizationStep.getName());
        authorizationStepDto.setDescription(authorizationStep.getDescription());
        authorizationStepDto.setEntityDto(toEntityDto(authorizationStep.getEntity()));
        return authorizationStepDto;
    }

    public AuthorizationStep toAuthorizationStep(AuthorizationStepDto authorizationStepDto) {
        if (authorizationStepDto == null) {
            return null;
        }
        AuthorizationStep authorizationStep = new AuthorizationStep();
        authorizationStep.setName(authorizationStepDto.getName());
        authorizationStep.setDescription(authorizationStepDto.getDescription());
        authorizationStep.setEntity(toEntity(authorizationStepDto.getEntityDto()));
        return authorizationStep;
    }

    public FormStepDto toFormStepDto(FormStep formStep) {
        if (formStep == null) {
            return null;
        }
        FormStepDto formStepDto = new FormStepDto();
        formStepDto.setName(formStep.getName());
        formStepDto.setDescription(formStep.getDescription());
        formStepDto.setEntityDto(toEntityDto(formStep.getEntity()));
        formStepDto.setForm(toFormDto(formStep.getForm()));
        return formStepDto;
    }

    public FormStep toFormStep(FormStepDto formStepDto) {
        if (formStepDto == null) {
            return null;
        }
        FormStep formStep = new FormStep();
        formStep.setName(formStepDto.getName());
        formStep.setDescription(formStepDto.getDescription());
        formStep.setEntity(toEntity(formStepDto.getEntityDto()));
        formStep.setForm(toForm(formStepDto.getForm()));
        return formStep;
    }

    private EntityDto toEntityDto(Entity entity) {
        if (entity == null) {
            return null;
        }
        return new EntityDto(
            entity.getId(),
            entity.getName(),
            EntityDto.Type.valueOf(entity.getType().name())
        );
    }

    private Entity toEntity(EntityDto entityDto) {
        if (entityDto == null) {
            return null;
        }
        return switch (entityDto.type()) {
            case UNIT -> unitService.findById(entityDto.id());
            case DEPARTMENT -> departmentService.findById(entityDto.id());
            case SECTOR -> sectorService.findById(entityDto.id());
            case TEAM -> teamService.findById(entityDto.id());
            case USER -> userReadService.findById(entityDto.id());
        };
    }

    private FormDto toFormDto(Form form) {
        if (form == null) {
            return null;
        }
        LinkedHashSet<QuestionDto> questions = form.getQuestions()
                .stream()
                .map(this::toQuestionDto)
                .collect(Collectors.toCollection(LinkedHashSet::new));
        return new FormDto(questions);
    }

    private Form toForm(FormDto formDto) {
        if (formDto == null) {
            return null;
        }
        LinkedHashSet<Question> questions = formDto.questions()
                .stream()
                .map(this::toQuestion)
                .collect(Collectors.toCollection(LinkedHashSet::new));
        return new Form(questions);
    }

    private QuestionDto toQuestionDto(Question question) {
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

    private Question toQuestion(QuestionDto questionDto) {
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

    private ShortTextQuestionDto toShortTextQuestionDto(ShortTextQuestion question) {
        ShortTextQuestionDto dto = new ShortTextQuestionDto();
        dto.setName(question.getName());
        dto.setDescription(question.getDescription());
        dto.setOptional(question.isOptional());
        return dto;
    }

    private LongTextQuestionDto toLongTextQuestionDto(LongTextQuestion question) {
        LongTextQuestionDto dto = new LongTextQuestionDto();
        dto.setName(question.getName());
        dto.setDescription(question.getDescription());
        dto.setOptional(question.isOptional());
        return dto;
    }

    private MultipleChoiceQuestionDto toMultipleChoiceQuestionDto(MultipleChoiceQuestion question) {
        MultipleChoiceQuestionDto dto = new MultipleChoiceQuestionDto();
        dto.setName(question.getName());
        dto.setDescription(question.getDescription());
        dto.setOptional(question.isOptional());
        dto.setOptions(question.getOptions());
        return dto;
    }

    private CheckBoxQuestionDto toCheckBoxQuestionDto(CheckBoxQuestion question) {
        CheckBoxQuestionDto dto = new CheckBoxQuestionDto();
        dto.setName(question.getName());
        dto.setDescription(question.getDescription());
        dto.setOptional(question.isOptional());
        dto.setLabel(question.getLabel());
        return dto;
    }

    private MultipleCheckBoxQuestionDto toMultipleCheckBoxQuestionDto(MultipleCheckBoxQuestion question) {
        MultipleCheckBoxQuestionDto dto = new MultipleCheckBoxQuestionDto();
        dto.setName(question.getName());
        dto.setDescription(question.getDescription());
        dto.setOptional(question.isOptional());
        dto.setLabels(question.getLabels());
        return dto;
    }

    private LinearScaleQuestionDto toLinearScaleQuestionDto(LinearScaleQuestion question) {
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

    private MultipleChoiceGridQuestionDto toMultipleChoiceGridQuestionDto(MultipleChoiceGridQuestion question) {
        MultipleChoiceGridQuestionDto dto = new MultipleChoiceGridQuestionDto();
        dto.setName(question.getName());
        dto.setDescription(question.getDescription());
        dto.setOptional(question.isOptional());
        dto.setRowsLabel(question.getRowsLabel());
        dto.setColumnsLabel(question.getColumnsLabel());
        return dto;
    }

    private MultipleCheckBoxGridQuestionDto toMultipleCheckBoxGridQuestionDto(MultipleCheckBoxGridQuestion question) {
        MultipleCheckBoxGridQuestionDto dto = new MultipleCheckBoxGridQuestionDto();
        dto.setName(question.getName());
        dto.setDescription(question.getDescription());
        dto.setOptional(question.isOptional());
        dto.setRowsLabel(question.getRowsLabel());
        dto.setColumnsLabel(question.getColumnsLabel());
        return dto;
    }

    private DateQuestionDto toDateQuestionDto(DateQuestion question) {
        DateQuestionDto dto = new DateQuestionDto();
        dto.setName(question.getName());
        dto.setDescription(question.getDescription());
        dto.setOptional(question.isOptional());
        return dto;
    }

    private DateTimeQuestionDto toDateTimeQuestionDto(DateTimeQuestion question) {
        DateTimeQuestionDto dto = new DateTimeQuestionDto();
        dto.setName(question.getName());
        dto.setDescription(question.getDescription());
        dto.setOptional(question.isOptional());
        return dto;
    }

    private TimeQuestionDto toTimeQuestionDto(TimeQuestion question) {
        TimeQuestionDto dto = new TimeQuestionDto();
        dto.setName(question.getName());
        dto.setDescription(question.getDescription());
        dto.setOptional(question.isOptional());
        return dto;
    }

    private ShortTextQuestion toShortTextQuestion(ShortTextQuestionDto dto) {
        ShortTextQuestion question = new ShortTextQuestion();
        question.setName(dto.getName());
        question.setDescription(dto.getDescription());
        question.setOptional(dto.isOptional());
        return question;
    }

    private LongTextQuestion toLongTextQuestion(LongTextQuestionDto dto) {
        LongTextQuestion question = new LongTextQuestion();
        question.setName(dto.getName());
        question.setDescription(dto.getDescription());
        question.setOptional(dto.isOptional());
        return question;
    }

    private MultipleChoiceQuestion toMultipleChoiceQuestion(MultipleChoiceQuestionDto dto) {
        MultipleChoiceQuestion question = new MultipleChoiceQuestion();
        question.setName(dto.getName());
        question.setDescription(dto.getDescription());
        question.setOptional(dto.isOptional());
        question.setOptions(dto.getOptions());
        return question;
    }

    private CheckBoxQuestion toCheckBoxQuestion(CheckBoxQuestionDto dto) {
        CheckBoxQuestion question = new CheckBoxQuestion();
        question.setName(dto.getName());
        question.setDescription(dto.getDescription());
        question.setOptional(dto.isOptional());
        question.setLabel(dto.getLabel());
        return question;
    }

    private MultipleCheckBoxQuestion toMultipleCheckBoxQuestion(MultipleCheckBoxQuestionDto dto) {
        MultipleCheckBoxQuestion question = new MultipleCheckBoxQuestion();
        question.setName(dto.getName());
        question.setDescription(dto.getDescription());
        question.setOptional(dto.isOptional());
        question.setLabels(dto.getLabels());
        return question;
    }

    private LinearScaleQuestion toLinearScaleQuestion(LinearScaleQuestionDto dto) {
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

    private MultipleChoiceGridQuestion toMultipleChoiceGridQuestion(MultipleChoiceGridQuestionDto dto) {
        MultipleChoiceGridQuestion question = new MultipleChoiceGridQuestion();
        question.setName(dto.getName());
        question.setDescription(dto.getDescription());
        question.setOptional(dto.isOptional());
        question.setRowsLabel(dto.getRowsLabel());
        question.setColumnsLabel(dto.getColumnsLabel());
        return question;
    }

    private MultipleCheckBoxGridQuestion toMultipleCheckBoxGridQuestion(MultipleCheckBoxGridQuestionDto dto) {
        MultipleCheckBoxGridQuestion question = new MultipleCheckBoxGridQuestion();
        question.setName(dto.getName());
        question.setDescription(dto.getDescription());
        question.setOptional(dto.isOptional());
        question.setRowsLabel(dto.getRowsLabel());
        question.setColumnsLabel(dto.getColumnsLabel());
        return question;
    }

    private DateQuestion toDateQuestion(DateQuestionDto dto) {
        DateQuestion question = new DateQuestion();
        question.setName(dto.getName());
        question.setDescription(dto.getDescription());
        question.setOptional(dto.isOptional());
        return question;
    }

    private DateTimeQuestion toDateTimeQuestion(DateTimeQuestionDto dto) {
        DateTimeQuestion question = new DateTimeQuestion();
        question.setName(dto.getName());
        question.setDescription(dto.getDescription());
        question.setOptional(dto.isOptional());
        return question;
    }

    private TimeQuestion toTimeQuestion(TimeQuestionDto dto) {
        TimeQuestion question = new TimeQuestion();
        question.setName(dto.getName());
        question.setDescription(dto.getDescription());
        question.setOptional(dto.isOptional());
        return question;
    }

}

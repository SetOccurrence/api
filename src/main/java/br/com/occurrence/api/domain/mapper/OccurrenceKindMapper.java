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

import java.time.LocalDateTime;
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
        occurrenceKind.setColor(form.color());
        occurrenceKind.setIcon(form.icon());
        occurrenceKind.setPrefix(form.prefix());
        occurrenceKind.setDescription(form.description());
        occurrenceKind.setCategory(form.category());
        occurrenceKind.setFlowMap(toFlowMap(form.flowMap()));
        occurrenceKind.setCreatedBy(UserReadService.me().getId().toString());
        occurrenceKind.setCreatedAt(LocalDateTime.now());
        return occurrenceKind;
    }

    public OccurrenceKindDto toOccurrenceKindDto(OccurrenceKind occurrenceKind) {
        return new OccurrenceKindDto(
            occurrenceKind.getId(),
            occurrenceKind.getName(),
            occurrenceKind.getIcon(),
            occurrenceKind.getColor(),
            occurrenceKind.getPrefix(),
            occurrenceKind.getInstances(),
            occurrenceKind.getDescription(),
            occurrenceKind.getCategory(),
            OccurrenceKindDto.Status.valueOf(occurrenceKind.getStatus().name()),
            toFlowMapDto(occurrenceKind.getFlowMap()),
            occurrenceKind.getCreatedBy(),
            occurrenceKind.getCreatedAt()
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
        formStepDto.setForm(FormMapper.toFormDto(formStep.getForm()));
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
        formStep.setForm(FormMapper.toForm(formStepDto.getForm()));
        return formStep;
    }

    public EntityDto toEntityDto(Entity entity) {
        if (entity == null) {
            return null;
        }
        return new EntityDto(
            entity.getId(),
            entity.getName(),
            EntityDto.Type.valueOf(entity.getType().name())
        );
    }

    public Entity toEntity(EntityDto entityDto) {
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

}

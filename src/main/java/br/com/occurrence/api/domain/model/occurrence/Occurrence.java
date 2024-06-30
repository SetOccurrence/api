package br.com.occurrence.api.domain.model.occurrence;

import br.com.occurrence.api.app.api.dto.occurrence.commons.flow.AuthorizationRegistryDto;
import br.com.occurrence.api.app.api.dto.occurrence.commons.flow.FlowRegistryDto;
import br.com.occurrence.api.app.api.dto.occurrence.commons.flow.FormRegistryDto;
import br.com.occurrence.api.app.api.dto.occurrence.commons.form.answer.*;
import br.com.occurrence.api.app.api.dto.occurrence.commons.step.FormStepDto;
import br.com.occurrence.api.domain.mapper.AnswerMapper;
import br.com.occurrence.api.domain.model.occurrence.commons.Comment;
import br.com.occurrence.api.domain.model.occurrence.commons.flow.AuthorizationRegistry;
import br.com.occurrence.api.domain.model.occurrence.commons.flow.Flow;
import br.com.occurrence.api.domain.model.occurrence.commons.flow.FlowRegistry;
import br.com.occurrence.api.domain.model.occurrence.commons.flow.FormRegistry;
import br.com.occurrence.api.domain.model.occurrence.commons.form.Form;
import br.com.occurrence.api.domain.model.occurrence.commons.form.answer.*;
import br.com.occurrence.api.domain.model.occurrence.commons.form.question.*;
import br.com.occurrence.api.domain.model.occurrence.commons.step.AuthorizationStep;
import br.com.occurrence.api.domain.model.occurrence.commons.step.FormStep;
import br.com.occurrence.api.domain.model.occurrence.commons.step.Step;
import br.com.occurrence.api.domain.model.organization.User;
import br.com.occurrence.api.domain.service.UserReadService;
import br.com.occurrence.api.domain.util.Auditable;
import br.com.occurrence.api.domain.util.exception.InvalidFormException;
import br.com.occurrence.api.domain.util.exception.WrongStepOccurrenceException;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.*;

@Getter
@Setter
@EqualsAndHashCode(of = {"id"}, callSuper = false)
public class Occurrence {

    private String id;
    private String name;
    private OccurrenceKind occurrenceKind;
    private Status status;
    private Flow flow;
    private List<Comment> comments;
    private String createdBy;
    private LocalDateTime createdAt;

    public Occurrence() {
        this.status = Status.OPEN;
        this.flow = new Flow(new LinkedList<>(), 0);
    }

    @Getter
    @AllArgsConstructor
    public enum Status {
        OPEN("Open"),
        CANCELED("Canceled"),
        FINISH("Finish"),
        DELETED("Deleted");

        private final String description;
    }

    public void resolve(FlowRegistryDto flowRegistryDto) {
        switch (flowRegistryDto.getStep().getType()) {
            case FORM -> resolve((FormRegistryDto) flowRegistryDto);
            case AUTHORIZATION -> resolve((AuthorizationRegistryDto) flowRegistryDto);
        }
    }

    public void resolve(FormRegistryDto formRegistryDto) {
        Step step = getCurrentStep();

        //check step type
        if (!Step.Type.FORM.equals(step.getType())) {
            throw new WrongStepOccurrenceException();
        }

        //check same step
        String stepDtoName = formRegistryDto.getStep().getName();
        if (!step.getName().equals(stepDtoName)) {
            throw new WrongStepOccurrenceException();
        }

        List<Answer> answers = AnswerMapper.toAnswer(formRegistryDto.getAnswers());
        validateAnswers((FormStep) step, answers);

        FormRegistry registry = createRegistry((FormStep) step, answers);
        flow.addFlowRegistry(registry, true);

        updateStatus();
    }

    public void resolve(AuthorizationRegistryDto authorizationRegistryDto) {
        Step step = getCurrentStep();

        //check step type
        if (!Step.Type.AUTHORIZATION.equals(step.getType())) {
            throw new WrongStepOccurrenceException();
        }

        //check same step
        String stepDtoName = authorizationRegistryDto.getStep().getName();
        if (!step.getName().equals(stepDtoName)) {
            throw new WrongStepOccurrenceException();
        }

        AuthorizationRegistry registry = createRegistry(
            (AuthorizationStep) step,
            AuthorizationRegistry.Action.valueOf(authorizationRegistryDto.getAction().name()),
            authorizationRegistryDto.getObservation()
        );

        boolean next = AuthorizationRegistry.Action.APPROVE.equals(registry.getAction());

        flow.addFlowRegistry(registry, next);

        updateStatus();
    }

    private void validateAnswers(FormStep step, List<Answer> answers) {
        // validar se respostas são validas
        for (Answer answer : answers) {
            if (!answer.isValid()) {
                throw new InvalidFormException("Resposta não valida para pergunta: " + answer.getQuestion().getName());
            }
        }

        //validar se contem as respostas das questões do formulario da etapa
        Set<Question> questions = step.getForm().getQuestions();

        if (questions.size() > answers.size()) {
            throw new InvalidFormException("Não pode haver mais respostas que perguntas");
        }

        for (Question question : questions) {
            if (question.isOptional()) {
                continue;
            }
            boolean exists = answers.stream()
                    .anyMatch(tryAnswer -> tryAnswer.getQuestion().getName().equals(question.getName()));
            if (!exists) {
                throw new InvalidFormException("Pergunta sem resposta: " + question.getName());
            }
        }
    }

    public Step getCurrentStep() {
        return occurrenceKind.getFlowMap().getSteps().get(this.flow.getStepIndex());
    }

    private void updateStatus() {
        //update
        boolean finish = (flow.getStepIndex() + 1) >= occurrenceKind.getFlowMap().getSteps().size();
        if (finish) {
            this.setStatus(Occurrence.Status.FINISH);
        }
    }

    private FormRegistry createRegistry(FormStep step, List<Answer> answers) {
        FormRegistry registry = new FormRegistry();
        registry.setStep(step);
        registry.setResolver(UserReadService.me());
        registry.setResolvedAt(LocalDateTime.now());
        registry.setAnswers(answers);
        return registry;
    }

    private AuthorizationRegistry createRegistry(AuthorizationStep step, AuthorizationRegistry.Action action, String observation) {
        AuthorizationRegistry registry = new AuthorizationRegistry();
        registry.setStep(step);
        registry.setResolver(UserReadService.me());
        registry.setResolvedAt(LocalDateTime.now());
        registry.setAction(action);
        registry.setObservation(observation);
        return registry;
    }

}

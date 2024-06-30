package br.com.occurrence.api;

import br.com.occurrence.api.domain.model.occurrence.Occurrence;
import br.com.occurrence.api.domain.model.occurrence.OccurrenceKind;
import br.com.occurrence.api.domain.model.occurrence.commons.flow.FlowMap;
import br.com.occurrence.api.domain.model.occurrence.commons.form.Form;
import br.com.occurrence.api.domain.model.occurrence.commons.form.question.DateQuestion;
import br.com.occurrence.api.domain.model.occurrence.commons.form.question.Question;
import br.com.occurrence.api.domain.model.occurrence.commons.form.question.ShortTextQuestion;
import br.com.occurrence.api.domain.model.occurrence.commons.step.AuthorizationStep;
import br.com.occurrence.api.domain.model.occurrence.commons.step.FormStep;
import br.com.occurrence.api.domain.model.occurrence.commons.step.Step;
import br.com.occurrence.api.domain.model.organization.Unit;
import br.com.occurrence.api.domain.model.organization.User;
import br.com.occurrence.api.domain.model.organization.commons.Address;
import br.com.occurrence.api.domain.model.organization.commons.Contact;
import br.com.occurrence.api.domain.repository.OccurrenceKindRepository;
import br.com.occurrence.api.domain.repository.OccurrenceRepository;
import br.com.occurrence.api.domain.repository.UnitRepository;
import br.com.occurrence.api.domain.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class Runner implements ApplicationRunner {

    private UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private UnitRepository unitRepository;
    private OccurrenceKindRepository occurrenceKindRepository;
    private OccurrenceRepository occurrenceRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        cleanOccurrences();
        cleanOccurrenceKind();
        User admin = obtainUser("Administrador", "admin");
        User user = obtainUser("Jonatan", "jonatan_birck"); 
        Unit unit = createUnit("Unidade A", user);
        OccurrenceKind kind = createOccurrenceKind(unit, user);
    }

    private void cleanOccurrences() {
        List<Occurrence> occurrenceList = occurrenceRepository.findAll(null);
        for (Occurrence occurrence : occurrenceList) {
            occurrenceRepository.deleteById(occurrence.getId());
        }
    }

    private void cleanOccurrenceKind() {
        List<OccurrenceKind> occurrenceKindList = occurrenceKindRepository.findAll(null);
        for (OccurrenceKind occurrenceKind : occurrenceKindList) {
            occurrenceKindRepository.deleteById(occurrenceKind.getId());
        }
    }

    private User obtainUser(String name, String login) {
        Optional<User> user = userRepository.findByLogin(login);
        return user.orElseGet(() -> createUser(name, login));
    }

    private User createUser(String name, String login) {
        User user = new User();
        user.setName(name);
        user.setEmail(login + "@setoccurrence.com");
        user.setLogin(login);
        user.setPassword(passwordEncoder.encode("teste123"));
        user.setContact(null);
        user.setTeam(null);
        user.setStatus(User.Status.ACTIVE);
        user.setCreatedBy("");
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedBy("");
        user.setUpdatedAt(null);
        return userRepository.create(user);
    }

    private Unit createUnit(String name, User responsible) {
        Unit unit = new Unit();
        unit.setName(name);
        unit.setDescription("descrição da unidade " + name);
        unit.setCreatedAt(LocalDateTime.now());
        unit.setCreatedBy(responsible.getLogin());
        unit.setResponsible(responsible);
        unit.setStatus(Unit.Status.ACTIVE);
        unit.setUpdatedAt(LocalDateTime.now());
        unit.setUpdatedBy(responsible.getLogin());
        unit.setAddress(new Address("", 0, "", "", "", "", "", ""));
        unit.setContact(new Contact("","51-95363100", ""));
        return unitRepository.create(unit);
    }

    private OccurrenceKind createOccurrenceKind(Unit unit, User user) {
        OccurrenceKind kind = new OccurrenceKind();
        kind.setName("Solicitação de férias");
        kind.setIcon("vacation");
        kind.setColor("blue");
        kind.setPrefix("SF");
        kind.setInstances(0);
        kind.setDescription("Processo para solicitação das férias");
        kind.setCategory("RH");
        kind.setStatus(OccurrenceKind.Status.ACTIVE);
        kind.setFlowMap(createFlowMap(unit, user));
        kind.setCreatedBy(user.getName());
        kind.setCreatedAt(LocalDateTime.now());
        return occurrenceKindRepository.create(kind);
    }

    private FlowMap createFlowMap(Unit unit, User user) {
        FlowMap flowMap = new FlowMap();
        flowMap.setSteps(createSteps(unit, user));
        return flowMap;
    }

    private LinkedList<Step> createSteps(Unit unit, User user) {
        LinkedList<Step> steps = new LinkedList<>();

        FormStep step1 = createStep1();
        AuthorizationStep step2 = createStep2(user);
        FormStep step3 = createStep3(unit);

        steps.add(step1);
        steps.add(step2);
        steps.add(step3);

        return steps;
    }

    private FormStep createStep1() {
        FormStep formStep = new FormStep();
        formStep.setName("Registro solicitação");
        formStep.setDescription("Etapa para registro da solicitação de férias");
        formStep.setEntity(null);
        formStep.setForm(createFormStep1());
        return formStep;
    }

    private AuthorizationStep createStep2(User user) {
        AuthorizationStep authorizationStep = new AuthorizationStep();
        authorizationStep.setName("Aprovação liderança");
        authorizationStep.setDescription("Etapa para aprovar a solicitação de férias");
        authorizationStep.setEntity(user);
        return authorizationStep;
    }

    private FormStep createStep3(Unit unit) {
        FormStep formStep = new FormStep();
        formStep.setName("Efetuação das férias (RH)");
        formStep.setDescription("Etapa para formalização das de férias");
        formStep.setEntity(unit);
        formStep.setForm(createFormStep3());
        return formStep;
    }

    private Form createFormStep1() {
        Form form = new Form();
        form.setQuestions(createQuestionsStep1());
        return form;
    }

    private Form createFormStep3() {
        Form form = new Form();
        form.setQuestions(createQuestionsStep3());
        return form;
    }

    private LinkedHashSet<Question> createQuestionsStep1() {
        LinkedHashSet<Question> questions = new LinkedHashSet<>();

        DateQuestion question1 = new DateQuestion();
        question1.setName("Data inicial");
        question1.setDescription("Selecione o inicio das férias");
        question1.setOptional(false);
        questions.add(question1);

        DateQuestion question2 = new DateQuestion();
        question2.setName("Data final");
        question2.setDescription("Selecione o fim das férias");
        question2.setOptional(false);
        questions.add(question2);

        ShortTextQuestion question3 = new ShortTextQuestion();
        question3.setName("Observações");
        question3.setDescription("Descreva alguma observação");
        question3.setOptional(true);
        questions.add(question3);

        return questions;
    }

    private LinkedHashSet<Question> createQuestionsStep3() {
        LinkedHashSet<Question> questions = new LinkedHashSet<>();

        ShortTextQuestion question3 = new ShortTextQuestion();
        question3.setName("Observações");
        question3.setDescription("Descreva alguma observação");
        question3.setOptional(false);
        questions.add(question3);

        return questions;
    }

}

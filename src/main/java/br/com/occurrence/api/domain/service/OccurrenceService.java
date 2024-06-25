package br.com.occurrence.api.domain.service;

import br.com.occurrence.api.app.api.dto.occurrence.OccurrenceFormDto;
import br.com.occurrence.api.app.api.dto.occurrence.commons.form.answer.AnswerDto;
import br.com.occurrence.api.domain.mapper.OccurrenceMapper;
import br.com.occurrence.api.domain.model.occurrence.Occurrence;
import br.com.occurrence.api.domain.model.occurrence.OccurrenceKind;
import br.com.occurrence.api.domain.model.occurrence.commons.form.answer.Answer;
import br.com.occurrence.api.domain.model.occurrence.commons.form.question.Question;
import br.com.occurrence.api.domain.model.occurrence.commons.step.FormStep;
import br.com.occurrence.api.domain.repository.OccurrenceRepository;
import br.com.occurrence.api.domain.util.exception.OccurrenceKindNotFoundException;
import br.com.occurrence.api.domain.util.filter.OccurrenceFilter;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.UUID;

@Slf4j
@AllArgsConstructor
@Service
public class OccurrenceService {

    private final OccurrenceKindService occurrenceKindService;
    private final OccurrenceRepository occurrenceRepository;
    private final OccurrenceMapper occurrenceMapper;

    public Page<Occurrence> findAll(Pageable pageable, OccurrenceFilter filter) {
        //return occurrenceRepository.findAll(pageable, filter);
        return null;
    }

    public Occurrence findById(UUID id) {
        //return occurrenceRepository.findById(id)
        //        .orElseThrow(OccurrenceKindNotFoundException::new);
        return null;
    }

    public Occurrence create(OccurrenceFormDto form) {
        // buscar kind
        // pegar instance
        // salvar kind
        // criar occurrence
        // preencher primeiro step registro
        // verificar e atualizar step (se tiver apenas um já finaliza)
        // salvar
        // devolver


        OccurrenceKind kind = findAndIncrementInstance(form.occurrenceKindId());


        Occurrence occurrence = new Occurrence();
        occurrence.setOccurrenceKind(kind);
        occurrence.setName(kind.getOccurrenceName());



        

        FormStep formStep = (FormStep) kind.getFlowMap().getSteps().get(0);
        LinkedHashSet<Question> questions = formStep.getForm().getQuestions();



        List<AnswerDto> answers = form.registry().getAnswers();








        //Occurrence occurrence = occurrenceMapper.toOccurrence(form);
        //return occurrenceRepository.create(occurrence);
        return null;
    }

    private OccurrenceKind findAndIncrementInstance(String occurrenceKindId) {
        OccurrenceKind kind = occurrenceKindService.findById(occurrenceKindId);
        long instance = kind.getInstances() + 1;
        kind.setInstances(instance);
        return occurrenceKindService.update(kind);
    }

    public Occurrence update(UUID id, OccurrenceFormDto form) {
        //Occurrence occurrence = findById(id);
        //occurrenceMapper.updateOccurrenceFromDto(occurrence, form);
        //return occurrenceRepository.update(occurrence);
        return null;
    }

    public Occurrence logicallyDelete(UUID id) {
        //Occurrence occurrence = findById(id);
        //occurrence.setStatus(Occurrence.Status.DELETED);
        //return occurrenceRepository.update(occurrence);
        return null;
    }

    public void deleteById(UUID id) {
        //occurrenceRepository.deleteById(id);
    }

}

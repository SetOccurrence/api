package br.com.occurrence.api.domain.service;

import br.com.occurrence.api.app.api.dto.occurrence.OccurrenceFormDto;
import br.com.occurrence.api.app.api.dto.occurrence.OccurrenceResolveDto;
import br.com.occurrence.api.app.api.dto.occurrence.commons.flow.FormRegistryDto;
import br.com.occurrence.api.app.api.dto.occurrence.commons.form.answer.*;
import br.com.occurrence.api.app.api.dto.occurrence.commons.step.FormStepDto;
import br.com.occurrence.api.domain.mapper.OccurrenceMapper;
import br.com.occurrence.api.domain.model.occurrence.Occurrence;
import br.com.occurrence.api.domain.model.occurrence.OccurrenceKind;
import br.com.occurrence.api.domain.model.occurrence.commons.flow.Flow;
import br.com.occurrence.api.domain.model.occurrence.commons.flow.FlowRegistry;
import br.com.occurrence.api.domain.model.occurrence.commons.flow.FormRegistry;
import br.com.occurrence.api.domain.model.occurrence.commons.form.answer.*;
import br.com.occurrence.api.domain.model.occurrence.commons.form.question.*;
import br.com.occurrence.api.domain.model.occurrence.commons.step.FormStep;
import br.com.occurrence.api.domain.repository.OccurrenceRepository;
import br.com.occurrence.api.domain.util.exception.OccurrenceNotFoundException;
import br.com.occurrence.api.domain.util.exception.WrongStepOccurrenceException;
import br.com.occurrence.api.domain.util.filter.OccurrenceFilter;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Slf4j
@AllArgsConstructor
@Service
public class OccurrenceService {

    private final OccurrenceKindService occurrenceKindService;
    private final OccurrenceRepository occurrenceRepository;
    private final OccurrenceMapper occurrenceMapper;

    public Page<Occurrence> findAll(Pageable pageable, OccurrenceFilter filter) {
        return occurrenceRepository.findAll(pageable, filter);
    }

    public List<Occurrence> findAll(OccurrenceFilter filter) {
        return occurrenceRepository.findAll(filter);
    }

    public Occurrence findById(String id) {
        return occurrenceRepository.findById(id)
                .orElseThrow(OccurrenceNotFoundException::new);
    }

    public Occurrence create(OccurrenceFormDto form) {
        OccurrenceKind kind = findAndIncrementInstance(form.occurrenceKindId());
        Occurrence occurrence = new Occurrence();
        occurrence.setOccurrenceKind(kind);
        occurrence.setName(kind.getOccurrenceName());
        occurrence.setStatus(Occurrence.Status.OPEN);
        occurrence.setCreatedAt(LocalDateTime.now());
        occurrence.setCreatedBy(UserReadService.me().getId().toString());
        occurrence.resolve(form.registry());
        return occurrenceRepository.create(occurrence);
    }

    public Occurrence resolve(String id, OccurrenceResolveDto resolveDto) {
        Occurrence occurrence = findById(id);
        occurrence.resolve(resolveDto.registry());
        return occurrenceRepository.update(occurrence);
    }

    private OccurrenceKind findAndIncrementInstance(String occurrenceKindId) {
        OccurrenceKind kind = occurrenceKindService.findById(occurrenceKindId);
        long instance = kind.getInstances() + 1;
        kind.setInstances(instance);
        return occurrenceKindService.update(kind);
    }

    public Occurrence update(String id, OccurrenceFormDto form) {
        //Occurrence occurrence = findById(id);
        //occurrenceMapper.updateOccurrenceFromDto(occurrence, form);
        //return occurrenceRepository.update(occurrence);
        return null;
    }

    public Occurrence logicallyDelete(String id) {
        Occurrence occurrence = findById(id);
        occurrence.setStatus(Occurrence.Status.DELETED);
        return occurrenceRepository.update(occurrence);
    }

    public void deleteById(String id) {
        occurrenceRepository.deleteById(id);
    }

}

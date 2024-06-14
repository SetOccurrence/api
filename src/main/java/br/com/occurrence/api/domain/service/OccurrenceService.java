package br.com.occurrence.api.domain.service;

import br.com.occurrence.api.app.api.dto.occurrence.OccurrenceFormDto;
import br.com.occurrence.api.domain.mapper.OccurrenceMapper;
import br.com.occurrence.api.domain.model.occurrence.Occurrence;
import br.com.occurrence.api.domain.repository.OccurrenceRepository;
import br.com.occurrence.api.domain.util.exception.OccurrenceKindNotFoundException;
import br.com.occurrence.api.domain.util.filter.OccurrenceFilter;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@AllArgsConstructor
@Service
public class OccurrenceService {

    private final OccurrenceRepository occurrenceRepository;
    private final OccurrenceMapper occurrenceMapper;

    public Page<Occurrence> findAll(Pageable pageable, OccurrenceFilter filter) {
        return occurrenceRepository.findAll(pageable, filter);
    }

    public Occurrence findById(UUID id) {
        return occurrenceRepository.findById(id)
                .orElseThrow(OccurrenceKindNotFoundException::new);
    }

    public Occurrence create(OccurrenceFormDto form) {
        //Occurrence occurrence = occurrenceMapper.toOccurrence(form);
        //return occurrenceRepository.create(occurrence);
        return null;
    }

    public Occurrence update(UUID id, OccurrenceFormDto form) {
        Occurrence occurrence = findById(id);
        occurrenceMapper.updateOccurrenceFromDto(occurrence, form);
        return occurrenceRepository.update(occurrence);
    }

    public Occurrence logicallyDelete(UUID id) {
        Occurrence occurrence = findById(id);
        occurrence.setStatus(Occurrence.Status.DELETED);
        return occurrenceRepository.update(occurrence);
    }

    public void deleteById(UUID id) {
        occurrenceRepository.deleteById(id);
    }

}

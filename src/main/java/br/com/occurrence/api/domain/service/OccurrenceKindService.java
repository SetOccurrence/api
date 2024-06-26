package br.com.occurrence.api.domain.service;

import br.com.occurrence.api.app.api.dto.occurrence.OccurrenceKindFormDto;
import br.com.occurrence.api.domain.mapper.OccurrenceKindMapper;
import br.com.occurrence.api.domain.model.occurrence.OccurrenceKind;
import br.com.occurrence.api.domain.repository.OccurrenceKindRepository;
import br.com.occurrence.api.domain.util.exception.OccurrenceKindNotFoundException;
import br.com.occurrence.api.domain.util.filter.OccurrenceKindFilter;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class OccurrenceKindService {

    private final OccurrenceKindRepository occurrenceKindRepository;
    private final OccurrenceKindMapper occurrenceKindMapper;

    public Page<OccurrenceKind> findAll(Pageable pageable, OccurrenceKindFilter filter) {
        return occurrenceKindRepository.findAll(pageable, filter);
    }

    public List<OccurrenceKind> findAll(OccurrenceKindFilter filter) {
        return occurrenceKindRepository.findAll(filter);
    }

    public OccurrenceKind findById(String id) {
        return occurrenceKindRepository.findById(id)
                .orElseThrow(OccurrenceKindNotFoundException::new);
    }

    public OccurrenceKind create(OccurrenceKindFormDto form) {
        OccurrenceKind occurrenceKind = occurrenceKindMapper.toOccurrenceKind(form);
        return occurrenceKindRepository.create(occurrenceKind);
    }

    public OccurrenceKind update(String id, OccurrenceKindFormDto form) {
        OccurrenceKind occurrenceKind = findById(id);
        occurrenceKindMapper.updateOccurrenceKindFromDto(occurrenceKind, form);
        return occurrenceKindRepository.update(occurrenceKind);
    }

    public OccurrenceKind update(OccurrenceKind occurrenceKind) {
        return occurrenceKindRepository.update(occurrenceKind);
    }

    public OccurrenceKind logicallyDelete(String id) {
        OccurrenceKind occurrenceKind = findById(id);
        occurrenceKind.setStatus(OccurrenceKind.Status.DELETED);
        return occurrenceKindRepository.update(occurrenceKind);
    }

    public void deleteById(String id) {
        occurrenceKindRepository.deleteById(id);
    }

}

package br.com.occurrence.api.domain.service;

import br.com.occurrence.api.app.api.dto.organization.SectorFormDto;
import br.com.occurrence.api.domain.mapper.SectorMapper;
import br.com.occurrence.api.domain.model.organization.Department;
import br.com.occurrence.api.domain.model.organization.Sector;
import br.com.occurrence.api.domain.model.organization.User;
import br.com.occurrence.api.domain.repository.SectorRepository;
import br.com.occurrence.api.domain.util.exception.SectorNotFoundException;
import br.com.occurrence.api.domain.util.filter.SectorFilter;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@AllArgsConstructor
@Service
public class SectorService {

    private final SectorRepository sectorRepository;
    private final UserReadService userReadService;
    private final DepartmentService departmentService;

    public Page<Sector> findAll(Pageable pageable, SectorFilter filter) {
        return sectorRepository.findAll(pageable, filter);
    }

    public List<Sector> findAll(SectorFilter filter) {
        return sectorRepository.findAll(filter);
    }

    public Sector findById(UUID id) {
        return sectorRepository.findById(id)
                .orElseThrow(() -> new SectorNotFoundException(id));
    }

    public Sector create(SectorFormDto sectorFormDTO) {
        User responsible = userReadService.findById(sectorFormDTO.responsibleId());
        Department department = departmentService.findById(sectorFormDTO.departmentId());
        Sector sector = SectorMapper.toSector(sectorFormDTO, responsible, department);
        return sectorRepository.create(sector);
    }

    public Sector update(UUID id, SectorFormDto sectorFormDTO) {
        Sector sector = findById(id);
        User responsible = userReadService.findById(sectorFormDTO.responsibleId());
        Department department = departmentService.findById(sectorFormDTO.departmentId());
        SectorMapper.updateSectorFromDTO(sector, sectorFormDTO, responsible, department);
        return sectorRepository.update(sector);
    }

    public Sector inactivate(UUID id) {
        Sector sector = findById(id);
        sector.setStatus(Sector.Status.INACTIVE);
        return sectorRepository.update(sector);
    }

    public Sector logicallyDelete(UUID id) {
        Sector sector = findById(id);
        sector.setStatus(Sector.Status.DELETED);
        return sectorRepository.update(sector);
    }

    public void deleteById(UUID id) {
        sectorRepository.deleteById(id);
    }

}

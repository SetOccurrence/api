package br.com.occurrence.api.domain.mapper;

import br.com.occurrence.api.app.api.dto.organization.SectorDto;
import br.com.occurrence.api.app.api.dto.organization.SectorFormDto;
import br.com.occurrence.api.app.api.dto.organization.TeamDto;
import br.com.occurrence.api.domain.model.organization.Department;
import br.com.occurrence.api.domain.model.organization.Sector;
import br.com.occurrence.api.domain.model.organization.Team;
import br.com.occurrence.api.domain.model.organization.User;
import br.com.occurrence.api.domain.util.PropertiesHelper;
import lombok.experimental.UtilityClass;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

@UtilityClass
public class SectorMapper {

    public static Sector toSector(SectorFormDto sectorFormDTO, User responsible, Department department) {
        if (sectorFormDTO == null) {
            return null;
        }
        Sector sector = new Sector();
        sector.setName(sectorFormDTO.name());
        sector.setDescription(sectorFormDTO.description());
        sector.setContact(ContactMapper.toContact(sectorFormDTO.contact()));
        sector.setResponsible(responsible);
        sector.setDepartment(department);
        return sector;
    }

    public static SectorDto toSectorDTO(Sector sector) {
        if (sector == null) {
            return null;
        }
        return new SectorDto(
            sector.getId(),
            sector.getName(),
            sector.getDescription(),
            UserMapper.toUserDTO(sector.getResponsible()),
            ContactMapper.toContactDto(sector.getContact()),
            DepartmentMapper.toDepartmentDTO(sector.getDepartment()),
            TeamMapper.toTeamDTO(sector.getTeams()),
            SectorDto.Status.valueOf(sector.getStatus().name())
        );
    }

    public static List<SectorDto> toSectorDTO(List<Sector> sectors) {
        if (CollectionUtils.isEmpty(sectors)) {
            return Collections.emptyList();
        }
        return sectors.stream()
                .map(SectorMapper::toSectorDTO)
                .toList();
    }

    public static void updateSectorFromDTO(Sector sector, SectorFormDto sectorFormDTO, User responsible, Department department) {
        if (sector == null) {
            return;
        }
        PropertiesHelper.copyNonNullProperties(sectorFormDTO, sector);
        if (responsible != null) {
            sector.setResponsible(responsible);
        }
        if (department != null) {
            sector.setDepartment(department);
        }
    }

}

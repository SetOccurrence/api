package br.com.occurrence.api.domain.mapper;

import br.com.occurrence.api.app.api.dto.SectorDto;
import br.com.occurrence.api.app.api.dto.SectorFormDto;
import br.com.occurrence.api.domain.model.Sector;
import br.com.occurrence.api.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SectorMapper {

    Sector toSector(SectorFormDto sectorFormDTO);

    default Sector toSector(SectorFormDto sectorFormDTO, User responsible) {
        if (sectorFormDTO == null) {
            return null;
        }
        Sector sector = toSector(sectorFormDTO);
        sector.setResponsible(responsible);
        return sector;
    }

    void updateSectorFromDTO(@MappingTarget Sector sector, SectorFormDto sectorFormDTO);

    default void updateSectorFromDTO(@MappingTarget Sector sector, SectorFormDto sectorFormDTO, User responsible) {
        if (sector == null) {
            return;
        }
        updateSectorFromDTO(sector, sectorFormDTO);
        sector.setResponsible(responsible);
    }

    SectorDto toSectorDTO(Sector sector);

}

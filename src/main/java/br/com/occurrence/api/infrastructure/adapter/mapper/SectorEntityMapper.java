package br.com.occurrence.api.infrastructure.adapter.mapper;

import br.com.occurrence.api.domain.model.Sector;
import br.com.occurrence.api.domain.util.filter.SectorFilter;
import br.com.occurrence.api.infrastructure.postgres.entity.SectorEntity;
import br.com.occurrence.api.infrastructure.postgres.specification.SectorSpecification;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SectorEntityMapper {

    SectorEntity toSectorEntity(Sector sector);
    Sector toSector(SectorEntity entity);

    SectorSpecification map(SectorFilter sectorFilter);

    Sector.Status map(SectorEntity.Status status);
    SectorEntity.Status map(Sector.Status status);

}

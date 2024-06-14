package br.com.occurrence.api.infrastructure.adapter.mapper;

import br.com.occurrence.api.domain.model.organization.Sector;
import br.com.occurrence.api.domain.util.filter.SectorFilter;
import br.com.occurrence.api.infrastructure.postgres.entity.SectorEntity;
import br.com.occurrence.api.infrastructure.postgres.specification.SectorSpecification;
import lombok.experimental.UtilityClass;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

@UtilityClass
public class SectorEntityMapper {

    public static SectorEntity toSectorEntity(Sector sector) {
        if (sector == null) {
            return null;
        }
        SectorEntity entity = new SectorEntity();
        entity.setId(sector.getId());
        entity.setName(sector.getName());
        entity.setDescription(sector.getDescription());
        entity.setDepartment(DepartmentEntityMapper.toDepartmentEntityWithoutRelations(sector.getDepartment()));
        entity.setResponsible(UserEntityMapper.toUserEntity(sector.getResponsible()));
        entity.setContact(ContactEntityMapper.toContactEntity(sector.getContact()));
        entity.setTeams(TeamEntityMapper.toTeamEntityWithoutRelations(sector.getTeams()));
        entity.setStatus(SectorEntity.Status.valueOf(sector.getStatus().name()));
        entity.setCreatedBy(sector.getCreatedBy());
        entity.setCreatedAt(sector.getCreatedAt());
        entity.setUpdatedBy(sector.getUpdatedBy());
        entity.setUpdatedAt(sector.getUpdatedAt());
        return entity;
    }

    public static SectorEntity toSectorEntityWithoutRelations(Sector sector) {
        if (sector == null) {
            return null;
        }
        SectorEntity entity = new SectorEntity();
        entity.setId(sector.getId());
        entity.setName(sector.getName());
        entity.setDescription(sector.getDescription());
        entity.setContact(ContactEntityMapper.toContactEntity(sector.getContact()));
        entity.setStatus(SectorEntity.Status.valueOf(sector.getStatus().name()));
        entity.setCreatedBy(sector.getCreatedBy());
        entity.setCreatedAt(sector.getCreatedAt());
        entity.setUpdatedBy(sector.getUpdatedBy());
        entity.setUpdatedAt(sector.getUpdatedAt());
        return entity;
    }

    public static List<SectorEntity> toSectorEntity(List<Sector> sectors) {
        if (CollectionUtils.isEmpty(sectors)) {
            return Collections.emptyList();
        }
        return sectors.stream()
                .map(SectorEntityMapper::toSectorEntity)
                .toList();
    }

    public static List<SectorEntity> toSectorEntityWithoutRelations(List<Sector> sectors) {
        if (CollectionUtils.isEmpty(sectors)) {
            return Collections.emptyList();
        }
        return sectors.stream()
                .map(SectorEntityMapper::toSectorEntityWithoutRelations)
                .toList();
    }

    public static Sector toSector(SectorEntity entity) {
        if (entity == null) {
            return null;
        }
        Sector sector = new Sector();
        sector.setId(entity.getId());
        sector.setName(entity.getName());
        sector.setDescription(entity.getDescription());
        sector.setResponsible(UserEntityMapper.toUser(entity.getResponsible()));
        sector.setDepartment(DepartmentEntityMapper.toDepartmentWithoutRelations(entity.getDepartment()));
        sector.setContact(ContactEntityMapper.toContact(entity.getContact()));
        sector.setTeams(TeamEntityMapper.toTeamWithoutRelations(entity.getTeams()));
        sector.setStatus(Sector.Status.valueOf(entity.getStatus().name()));
        sector.setCreatedBy(entity.getCreatedBy());
        sector.setCreatedAt(entity.getCreatedAt());
        sector.setUpdatedBy(entity.getUpdatedBy());
        sector.setUpdatedAt(entity.getUpdatedAt());
        return sector;
    }

    public static Sector toSectorWithoutRelations(SectorEntity entity) {
        if (entity == null) {
            return null;
        }
        Sector sector = new Sector();
        sector.setId(entity.getId());
        sector.setName(entity.getName());
        sector.setDescription(entity.getDescription());
        sector.setContact(ContactEntityMapper.toContact(entity.getContact()));
        sector.setStatus(Sector.Status.valueOf(entity.getStatus().name()));
        sector.setCreatedBy(entity.getCreatedBy());
        sector.setCreatedAt(entity.getCreatedAt());
        sector.setUpdatedBy(entity.getUpdatedBy());
        sector.setUpdatedAt(entity.getUpdatedAt());
        return sector;
    }

    public static List<Sector> toSector(List<SectorEntity> entities) {
        if (CollectionUtils.isEmpty(entities)) {
            return Collections.emptyList();
        }
        return entities.stream()
                .map(SectorEntityMapper::toSector)
                .toList();
    }

    public static List<Sector> toSectorWithoutRelations(List<SectorEntity> entities) {
        if (CollectionUtils.isEmpty(entities)) {
            return Collections.emptyList();
        }
        return entities.stream()
                .map(SectorEntityMapper::toSectorWithoutRelations)
                .toList();
    }

    public static SectorSpecification map(SectorFilter filter) {
        if (filter == null) {
            return null;
        }
        SectorSpecification specification = new SectorSpecification();
        specification.setName(filter.name());
        specification.setResponsibleId(filter.responsible() != null ? filter.responsible().id() : null);
        specification.setResponsibleName(filter.responsible() != null ? filter.responsible().name() : null);
        specification.setStatus(filter.status() != null ? SectorEntity.Status.valueOf(filter.status().name()) : null);
        return specification;
    }


}

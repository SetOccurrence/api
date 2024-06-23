package br.com.occurrence.api.domain.service;

import br.com.occurrence.api.app.api.dto.organization.commons.EntityDto;
import br.com.occurrence.api.app.api.dto.organization.commons.OrganizationTreeDto;
import br.com.occurrence.api.domain.mapper.UserMapper;
import br.com.occurrence.api.domain.model.organization.*;
import br.com.occurrence.api.domain.util.filter.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class OrganizationService {

    private final UnitService unitService;
    private final DepartmentService departmentService;
    private final SectorService sectorService;
    private final TeamService teamService;
    private final UserReadService userReadService;
    
    public OrganizationTreeDto findOrgnanization(OrganizationFilter filter) {
        
        List<OrganizationTreeDto.OrganizationTreeItemDto> unitsTree =  new LinkedList<>();
        
        //Units
        List<Unit> units = unitService.findAll(new UnitFilter(filter.search(), null, null));
        List<Department> departments = departmentService.findAll(new DepartmentFilter(filter.search(), null, null, null));
        List<Sector> sectors = sectorService.findAll(new SectorFilter(filter.search(), null, null, null));
        List<Team> teams = teamService.findAll(new TeamFilter(filter.search(), null, null, null));
        List<User> noRelationUsers = userReadService.findAll(new UserFilter().withSearch(filter.search())).stream()
                .filter(user -> user.getTeam() == null)
                .filter(user -> !Objects.equals(user.getLogin(), "admin"))
                .toList();

        //Units
        for (Unit unit : units) {
            unitsTree.add(new OrganizationTreeDto.OrganizationTreeItemDto(
                new EntityDto(unit.getId(), unit.getName(), EntityDto.Type.UNIT),
                new LinkedList<>()
            ));
        }

        //Departments
        for (Department department : departments) {
            OrganizationTreeDto.OrganizationTreeItemDto unitTree = unitsTree.stream()
                    .filter(unitTree1 -> unitTree1.entity().id().equals(department.getUnit().getId()))
                    .findFirst()
                    .get();
            unitTree.children().add(new OrganizationTreeDto.OrganizationTreeItemDto(
                    new EntityDto(department.getId(), department.getName(), EntityDto.Type.DEPARTMENT),
                    new LinkedList<>()
            ));
        }

        //Sectors
        for (Sector sector : sectors) {
            OrganizationTreeDto.OrganizationTreeItemDto departmentTree = unitsTree.stream()
                    .flatMap(unitTree1 -> unitTree1.children().stream())
                    .filter(departmentTree1 -> departmentTree1.entity().id().equals(sector.getDepartment().getId()))
                    .findFirst()
                    .get();
            departmentTree.children().add(new OrganizationTreeDto.OrganizationTreeItemDto(
                    new EntityDto(sector.getId(), sector.getName(), EntityDto.Type.SECTOR),
                    new LinkedList<>()
            ));
        }

        //Teams
        for (Team team : teams) {
            OrganizationTreeDto.OrganizationTreeItemDto sectorTree = unitsTree.stream()
                    .flatMap(unitTree1 -> unitTree1.children().stream())
                    .flatMap(departmentTree1 -> departmentTree1.children().stream())
                    .filter(sectorsTree1 -> sectorsTree1.entity().id().equals(team.getSector().getId()))
                    .findFirst()
                    .get();
            List<OrganizationTreeDto.OrganizationTreeItemDto> users = team.getUsers().stream().map(user -> new OrganizationTreeDto.OrganizationTreeItemDto(
                    new EntityDto(user.getId(), user.getName(), EntityDto.Type.USER),
                    null
            )).toList();
            sectorTree.children().add(new OrganizationTreeDto.OrganizationTreeItemDto(
                new EntityDto(team.getId(), team.getName(), EntityDto.Type.TEAM),
                users
            ));
        }

        return new OrganizationTreeDto(unitsTree, UserMapper.toUserDTO(noRelationUsers));
    }

}

package br.com.occurrence.api.app.api.controller;

import br.com.occurrence.api.app.api.dto.organization.commons.OrganizationTreeDto;
import br.com.occurrence.api.domain.service.OrganizationService;
import br.com.occurrence.api.domain.util.filter.OrganizationFilter;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/organization")
public class OrganizationController {

    private final OrganizationService organizationService;

    @GetMapping
    public ResponseEntity<OrganizationTreeDto> findAll(OrganizationFilter filter) {
        return ResponseEntity.ok(organizationService.findOrgnanization());
    }

}

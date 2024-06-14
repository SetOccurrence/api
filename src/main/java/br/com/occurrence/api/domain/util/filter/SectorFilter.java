package br.com.occurrence.api.domain.util.filter;

import br.com.occurrence.api.domain.model.organization.Sector;

public record SectorFilter(String name, User responsible, Sector.Status status) {
    public record User(String id, String name) {
    }
}
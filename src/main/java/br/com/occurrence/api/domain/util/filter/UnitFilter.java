package br.com.occurrence.api.domain.util.filter;

import br.com.occurrence.api.domain.model.organization.Unit;

public record UnitFilter(String name, User responsible, Unit.Status status) {
    public record User(String id, String name) {
    }
}
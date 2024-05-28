package br.com.occurrence.api.domain.util.filter;

import br.com.occurrence.api.domain.model.Team;

public record TeamFilter(String name, User responsible, Team.Status status) {
    public record User(String id, String name) {
    }
}
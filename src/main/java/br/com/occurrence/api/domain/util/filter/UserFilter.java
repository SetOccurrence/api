package br.com.occurrence.api.domain.util.filter;

import br.com.occurrence.api.domain.model.User;

public record UserFilter(String name, String email, String login, User.Status status) {
}

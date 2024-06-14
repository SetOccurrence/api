package br.com.occurrence.api.domain.util.filter;

import br.com.occurrence.api.domain.model.organization.Department;

public record DepartmentFilter(String name, User responsible, Department.Status status) {
    public record User(String id, String name) {
    }
}
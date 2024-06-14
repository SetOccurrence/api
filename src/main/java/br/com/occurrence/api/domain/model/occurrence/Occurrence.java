package br.com.occurrence.api.domain.model.occurrence;

import br.com.occurrence.api.domain.model.occurrence.commons.flow.Flow;
import br.com.occurrence.api.domain.model.organization.User;
import br.com.occurrence.api.domain.model.occurrence.commons.Comment;
import br.com.occurrence.api.domain.util.Auditable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode(of = {"id"}, callSuper = false)
public class Occurrence extends Auditable<User> {

    private UUID id;
    private String name;
    private OccurrenceKind occurrenceKind;
    private Status status = Status.OPEN;
    private Flow flow;
    private List<Comment> comments;

    @Getter
    @AllArgsConstructor
    public enum Status {
        OPEN("Open"),
        CANCELED("Canceled"),
        FINISH("Finish"),
        DELETED("Deleted");

        private final String description;
    }

}

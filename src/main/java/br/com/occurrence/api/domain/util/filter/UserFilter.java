package br.com.occurrence.api.domain.util.filter;

import br.com.occurrence.api.domain.model.organization.User;
import lombok.*;

@Getter
@Setter
@Builder
@With
@NoArgsConstructor
@AllArgsConstructor
public class UserFilter {

    private String search;
    private User.Status status;

}
